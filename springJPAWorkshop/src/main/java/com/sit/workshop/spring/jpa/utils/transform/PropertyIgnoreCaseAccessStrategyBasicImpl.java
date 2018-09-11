package com.sit.workshop.spring.jpa.utils.transform;

import org.hibernate.property.access.spi.PropertyAccess;
import org.hibernate.property.access.spi.PropertyAccessStrategy;

public class PropertyIgnoreCaseAccessStrategyBasicImpl implements PropertyAccessStrategy {

	/**
	 * Singleton access
	 */
	public static final PropertyIgnoreCaseAccessStrategyBasicImpl INSTANCE = new PropertyIgnoreCaseAccessStrategyBasicImpl();

	@Override
	public PropertyAccess buildPropertyAccess(Class containerJavaType, final String propertyName) {
		return new PropertyIgnoreCaseAccessBasicImpl( this, containerJavaType, propertyName );
	}
}
