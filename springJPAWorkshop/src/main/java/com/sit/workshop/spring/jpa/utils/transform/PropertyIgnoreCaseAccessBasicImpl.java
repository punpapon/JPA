package com.sit.workshop.spring.jpa.utils.transform;

import java.beans.Introspector;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Locale;

import javax.persistence.Transient;

import org.hibernate.MappingException;
import org.hibernate.PropertyNotFoundException;
import org.hibernate.property.access.spi.Getter;
import org.hibernate.property.access.spi.GetterMethodImpl;
import org.hibernate.property.access.spi.PropertyAccess;
import org.hibernate.property.access.spi.PropertyAccessStrategy;
import org.hibernate.property.access.spi.Setter;
import org.hibernate.property.access.spi.SetterMethodImpl;
import org.jboss.logging.Logger;

public class PropertyIgnoreCaseAccessBasicImpl implements PropertyAccess {
	private static final Logger log = Logger.getLogger( PropertyIgnoreCaseAccessBasicImpl.class );

	private final PropertyIgnoreCaseAccessStrategyBasicImpl strategy;
	private final GetterMethodImpl getter;
	private final SetterMethodImpl setter;

	public PropertyIgnoreCaseAccessBasicImpl(
			PropertyIgnoreCaseAccessStrategyBasicImpl strategy,
			Class containerJavaType,
			final String propertyName) {
		this.strategy = strategy;

		// final Method getterMethod = ReflectHelper.findGetterMethod( containerJavaType, propertyName );
		final Method getterMethod = findGetterMethod( containerJavaType, propertyName );
		this.getter = new GetterMethodImpl( containerJavaType, propertyName, getterMethod );

		// final Method setterMethod = ReflectHelper.findSetterMethod( containerJavaType, propertyName, getterMethod.getReturnType() );
		final Method setterMethod = findSetterMethod( containerJavaType, propertyName, getterMethod.getReturnType() );
		this.setter = new SetterMethodImpl( containerJavaType, propertyName, setterMethod );
	}

	@Override
	public PropertyAccessStrategy getPropertyAccessStrategy() {
		return strategy;
	}

	@Override
	public Getter getGetter() {
		return getter;
	}

	@Override
	public Setter getSetter() {
		return setter;
	}
	
	/* ***************************************
	 * 				Getter
	 * *************************************** */
	private static Method findGetterMethod(Class containerClass, String propertyName) {
		Class checkClass = containerClass;
		Method getter = null;

		// check containerClass, and then its super types (if any)
		while ( getter == null && checkClass != null ) {
			if ( checkClass.equals( Object.class ) ) {
				break;
			}

			getter = getGetterOrNull( checkClass, propertyName );

			// if no getter found yet, check all implemented interfaces
			if ( getter == null ) {
				getter = getGetterOrNull( checkClass.getInterfaces(), propertyName );
			}

			checkClass = checkClass.getSuperclass();
		}


		if ( getter == null ) {
			throw new PropertyNotFoundException(
					String.format(
							Locale.ROOT,
							"Could not locate getter method for property [%s#%s]",
							containerClass.getName(),
							propertyName
					)
			);
		}

		ensureAccessibility( getter );

		return getter;
	}
	
	private static void ensureAccessibility(AccessibleObject accessibleObject) {
		if ( accessibleObject.isAccessible() ) {
			return;
		}

		accessibleObject.setAccessible( true );
	}
	
	private static Method getGetterOrNull(Class[] interfaces, String propertyName) {
		Method getter = null;
		for ( int i = 0; getter == null && i < interfaces.length; ++i ) {
			final Class anInterface = interfaces[i];
			getter = getGetterOrNull( anInterface, propertyName );
			if ( getter == null ) {
				// if no getter found yet, check all implemented interfaces of interface
				getter = getGetterOrNull( anInterface.getInterfaces(), propertyName );
			}
		}
		return getter;
	}
	
	private static Method getGetterOrNull(Class containerClass, String propertyName) {
		for ( Method method : containerClass.getDeclaredMethods() ) {
			// if the method has parameters, skip it
			if ( method.getParameterCount() != 0 ) {
				continue;
			}

			// if the method is a "bridge", skip it
			if ( method.isBridge() ) {
				continue;
			}

			if ( method.getAnnotation( Transient.class ) != null ) {
				continue;
			}

			if ( Modifier.isStatic( method.getModifiers() ) ) {
				continue;
			}

			final String methodName = method.getName();

			// try "get"
			if ( methodName.startsWith( "get" ) ) {
				final String stemName = methodName.substring( 3 );
				final String decapitalizedStemName = Introspector.decapitalize( stemName );
				if ( stemName.equalsIgnoreCase( propertyName ) || decapitalizedStemName.equalsIgnoreCase( propertyName )) {
					verifyNoIsVariantExists( containerClass, propertyName, method, stemName );
					return method;
				}

			}

			// if not "get", then try "is"
			if ( methodName.startsWith( "is" ) ) {
				final String stemName = methodName.substring( 2 );
				String decapitalizedStemName = Introspector.decapitalize( stemName );
				if ( stemName.equalsIgnoreCase( propertyName ) || decapitalizedStemName.equalsIgnoreCase( propertyName ) ) {
					verifyNoGetVariantExists( containerClass, propertyName, method, stemName );
					return method;
				}
			}
		}

		return null;
	}
	
	private static void checkGetAndIsVariants(
			Class containerClass,
			String propertyName,
			Method getMethod,
			Method isMethod) {
		// Check the return types.  If they are the same, its ok.  If they are different
		// we are in a situation where we could not reasonably know which to use.
		if ( !isMethod.getReturnType().equals( getMethod.getReturnType() ) ) {
			throw new MappingException(
					String.format(
							Locale.ROOT,
							"In trying to locate getter for property [%s], Class [%s] defined " +
									"both a `get` [%s] and `is` [%s] variant",
							propertyName,
							containerClass.getName(),
							getMethod.toString(),
							isMethod.toString()
					)
			);
		}
	}
	
	private static void verifyNoIsVariantExists(
			Class containerClass,
			String propertyName,
			Method getMethod,
			String stemName) {
		// verify that the Class does not also define a method with the same stem name with 'is'
		try {
			final Method isMethod = containerClass.getDeclaredMethod( "is" + stemName );
			if ( !Modifier.isStatic( isMethod.getModifiers() ) && isMethod.getAnnotation( Transient.class ) == null ) {
				// No such method should throw the caught exception.  So if we get here, there was
				// such a method.
				checkGetAndIsVariants( containerClass, propertyName, getMethod, isMethod );
			}
		}
		catch (NoSuchMethodException ignore) {
		}
	}
	
	private static void verifyNoGetVariantExists(
			Class containerClass,
			String propertyName,
			Method isMethod,
			String stemName) {
		// verify that the Class does not also define a method with the same stem name with 'is'
		try {
			final Method getMethod = containerClass.getDeclaredMethod( "get" + stemName );
			// No such method should throw the caught exception.  So if we get here, there was
			// such a method.
			if ( !Modifier.isStatic( getMethod.getModifiers() ) && getMethod.getAnnotation( Transient.class ) == null ) {
				checkGetAndIsVariants( containerClass, propertyName, getMethod, isMethod );
			}
		}
		catch (NoSuchMethodException ignore) {
		}
	}

	private static Method getterMethodOrNull(Class containerJavaType, String propertyName) {
		try {
			return findGetterMethod( containerJavaType, propertyName );
		}
		catch (PropertyNotFoundException e) {
			return null;
		}
	}
	
	/* ***************************************
	 * 				Setter
	 * *************************************** */
	private static Method findSetterMethod(final Class containerClass, final String propertyName, final Class propertyType) {
		final Method setter = setterMethodOrNull( containerClass, propertyName, propertyType );
		if ( setter == null ) {
			throw new PropertyNotFoundException(
					String.format(
							Locale.ROOT,
							"Could not locate setter method for property [%s#%s]",
							containerClass.getName(),
							propertyName
					)
			);
		}
		return setter;
	}

	private static Method setterOrNull(Class[] interfaces, String propertyName, Class propertyType) {
		Method setter = null;
		for ( int i = 0; setter == null && i < interfaces.length; ++i ) {
			final Class anInterface = interfaces[i];
			setter = setterOrNull( anInterface, propertyName, propertyType );
			if ( setter == null ) {
				// if no setter found yet, check all implemented interfaces of interface
				setter = setterOrNull( anInterface.getInterfaces(), propertyName, propertyType );
			}
		}
		return setter;
	}

	private static Method setterOrNull(Class theClass, String propertyName, Class propertyType) {
		Method potentialSetter = null;

		for ( Method method : theClass.getDeclaredMethods() ) {
			final String methodName = method.getName();
			if ( method.getParameterCount() == 1 && methodName.startsWith( "set" ) ) {
				final String testOldMethod = methodName.substring( 3 );
				final String testStdMethod = Introspector.decapitalize( testOldMethod );
				if ( testStdMethod.equalsIgnoreCase( propertyName ) || testOldMethod.equalsIgnoreCase( propertyName ) ) {
					potentialSetter = method;
					if ( propertyType == null || method.getParameterTypes()[0].equals( propertyType ) ) {
						break;
					}
				}
			}
		}

		return potentialSetter;
	}
	
	private static Method setterMethodOrNull(final Class containerClass, final  String propertyName, final Class propertyType) {
		Class checkClass = containerClass;
		Method setter = null;

		// check containerClass, and then its super types (if any)
		while ( setter == null && checkClass != null ) {
			if ( checkClass.equals( Object.class ) ) {
				break;
			}

			setter = setterOrNull( checkClass, propertyName, propertyType );

			// if no setter found yet, check all implemented interfaces
			if ( setter == null ) {
				setter = setterOrNull( checkClass.getInterfaces(), propertyName, propertyType );
			}
			else {
				ensureAccessibility( setter );
			}

			checkClass = checkClass.getSuperclass();
		}
		return setter; // might be null
	}
}
