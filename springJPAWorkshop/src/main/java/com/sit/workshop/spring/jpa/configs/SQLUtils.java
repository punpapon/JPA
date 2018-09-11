package com.sit.workshop.spring.jpa.configs;

import java.beans.Introspector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Transient;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ResourceUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sit.commons.CommonSearchCriteria;
import com.sit.commons.HeaderSorts;
import com.sit.workshop.spring.jpa.configs.dimains.CriteriaParameter;


public class SQLUtils {
	private static String NEW_LINE = System.getProperty("line.separator");
	private static String ORDER_BY_PARAMETER = ":orderBy";

	private static Map<String, String[]> sqlMap = new LinkedHashMap<String, String[]>();
	
	/**
	 * Get select item query by query name, term and limit
	 * 
	 * @param entityManager
	 * @param queryName
	 * @param term
	 * @param limit
	 * @return
	 */
	public static Query getQuery(EntityManager entityManager, String queryName, String term, Integer limit) {
		Query query = null;
		
		try {
			String[] sqlLines = sqlMap.get(queryName);
			if (sqlLines != null || entityManager == null) {
				List<String> list = new ArrayList<String>();
				boolean hadTerm = false;
				boolean hadLimit = false;

				for (String line : sqlLines) {

					if (line.contains(":term")) {
						hadTerm = true;
						if (term == null) {
							hadTerm = false;
							continue;
						}
					}
					
					if (line.contains(":limit")) {
						hadLimit = true;
						if (limit == null) {
							hadLimit = false;
							continue;
						}
					}
					
					list.add(line);
				}

				// Create SQL
				String sql = StringUtils.join(list, NEW_LINE);

				// Create Query
				query = entityManager.createNativeQuery(sql);
				
				if(hadTerm) {
					query.setParameter("term", term);
				}
				
				if(hadLimit) {
					query.setParameter("limit", limit);
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return query;
	}

	/**
	 * Set offset limit by criteria
	 * 
	 * @param query
	 * @param criteria
	 */
	public static void setOffsetLimit(Query query, CommonSearchCriteria criteria) {
		if (criteria == null) {
			return;
		}

		if (criteria.getLinePerPage() > 0) {
			query.setMaxResults(criteria.getLinePerPage());
		}

		if (criteria.getLinePerPage() > 0 && criteria.getPageIndex() > 0) {
			int offset = criteria.getPageIndex();
			offset *= criteria.getLinePerPage();
			query.setFirstResult(offset);
		}
	}
	
	/**
	 * Get single result native query by query name, criteria and result set mapping
	 * 
	 * @param entityManager
	 * @param queryName
	 * @param criteria
	 * @param resultSetMapping
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Query getSingleResultQuery(EntityManager entityManager, String queryName, CommonSearchCriteria criteria, String resultSetMapping) throws IllegalAccessException, InvocationTargetException {
		// Process Criteria keep to Map
		Map<String, CriteriaParameter> parameterMap = keepCriteriaToMap(criteria);
		
		// Get SQL String
		String sql = getSQL(queryName, criteria, parameterMap);

		// Create Query
		Query query = entityManager.createNativeQuery(sql, resultSetMapping);
		
		// Set criteria
		setCriteria(parameterMap, query);
				
		return query;
	}
	
	/**
	 * Get native query by query name and  criteria
	 * 
	 * @param entityManager
	 * @param queryName
	 * @param criteria
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Query getQuery(EntityManager entityManager, String queryName, CommonSearchCriteria criteria) throws IllegalAccessException, InvocationTargetException {

		// Process Criteria keep to Map
		Map<String, CriteriaParameter> parameterMap = keepCriteriaToMap(criteria);
		
		// Get SQL String
		String sql = getSQL(queryName, criteria, parameterMap);

		// Create Query
		Query query = entityManager.createNativeQuery(sql);
		
		// Set criteria
		setCriteria(parameterMap, query);
				
		return query;
	}

	private static void setCriteria(Map<String, CriteriaParameter> parameterMap, Query query) {
		for (String parameterName : parameterMap.keySet()) {
			CriteriaParameter parameter = parameterMap.get(parameterName);
			if(parameter.getData() != null && parameter.isHadParameter()) {
				query.setParameter(parameterName, parameter.getData());
			}
		}
	}

	private static String getSQL(String queryName, CommonSearchCriteria criteria, Map<String, CriteriaParameter> parameterMap) {
		String sql = null;
		
		// Get Order By
		String orderBy = "";
		HeaderSorts[] headerSorts = criteria.getHeaderSorts();
		if (headerSorts != null && headerSorts.length > 0) {
			List<String> valueList = new ArrayList<String>();
			for (HeaderSorts headerSort : headerSorts) {
				valueList.add(headerSort.getColumnName() + " " + headerSort.getOrder());
			}

			orderBy = StringUtils.join(valueList, ",");
		}

		// Get SQL
		String[] sqlLines = sqlMap.get(queryName);
		if (sqlLines != null) {
			List<String> list = new ArrayList<String>();

			for (String line : sqlLines) {

				// Set orderBy parameter
				if (line.contains(ORDER_BY_PARAMETER)) {
					line = line.replaceAll(ORDER_BY_PARAMETER, orderBy);
				}
				
				// Process criteria parameter
				boolean isScript = false;
				for (String parameterName : parameterMap.keySet()) {
					
					if (line.contains(":" + parameterName)) {
						
						CriteriaParameter parameter = parameterMap.get(parameterName);
						parameter.setHadParameter(true);
						
						if(parameter.getData() == null) {
							isScript = true;
						}
						
						break;
					}					
				}
				
				if (!isScript) {
					list.add(line);
				}
			}

			// Create SQL
			sql = StringUtils.join(list, NEW_LINE);
		}
		
		return sql;
	}

	private static Map<String, CriteriaParameter> keepCriteriaToMap(CommonSearchCriteria criteria) throws IllegalAccessException, InvocationTargetException {
		
		Map<String, CriteriaParameter> paramMap = new LinkedHashMap<String, CriteriaParameter>();
		for (Method method : criteria.getClass().getDeclaredMethods()) {
			if (isContinue(method)) {
				continue;
			}

			// Cheack Method
			final String methodName = method.getName();

			if (methodName.startsWith("get")) {
				final String stemName = methodName.substring(3);
				final String decapitalizedStemName = Introspector.decapitalize(stemName);
				
				// Keep value
				Object value = method.invoke(criteria, null);
				
				// Create CriteriaParameter Object
				CriteriaParameter parameter = new CriteriaParameter(decapitalizedStemName, value);				
				paramMap.put(parameter.getName(), parameter);

				// check list size 0
				Type returnType = method.getGenericReturnType();
				if (value != null && returnType instanceof ParameterizedType) {
					List<Object> lstObject = (List<Object>) value;
					if (lstObject.size() == 0) {
						// Clear entry list
						parameter.setData(null);
					}
				}				
			}
		}
		
		return paramMap;
	}
	
	private static boolean isContinue(Method method) {
		return ((method.getParameterCount() != 0) // if the method has parameters, skip it
				|| (method.isBridge()) // if the method is a "bridge", skip it
				|| (method.getAnnotation(Transient.class) != null) || (Modifier.isStatic(method.getModifiers())));
	}
		
	/**
	 * Initial SQL config 
	 * 
	 * @param mappingResources
	 */
	protected static void init(String[] mappingResources) {
		if (mappingResources == null || mappingResources.length < 1) {
			return;
		}

		try {
			// Create DocumentFactory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
			factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
			factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			factory.setXIncludeAware(false);
			factory.setExpandEntityReferences(false);

			ClassLoader classLoader = SQLUtils.class.getClassLoader();
			for (String resources : mappingResources) {
				File file = ResourceUtils.getFile("classpath:" + resources);
				process(factory, file);

			}
		} catch (ParserConfigurationException | IllegalAccessException | InvocationTargetException
				| FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void process(DocumentBuilderFactory factory, File xmlFile)
			throws IllegalAccessException, InvocationTargetException {
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(xmlFile);

			// Create XPathFactory object
			XPathFactory xpathFactory = XPathFactory.newInstance();

			// Create XPath object
			XPath xpath = xpathFactory.newXPath();

			// Get SQL(native-query) to Map
			getQueryFromDocument(doc, xpath);

		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
			e.printStackTrace();
		}
	}

	private static void getQueryFromDocument(Document doc, XPath xpath) throws XPathExpressionException {
		NodeList nodes = (NodeList) xpath.compile("/entity-mappings/named-native-query").evaluate(doc,
				XPathConstants.NODESET);
		int length = nodes.getLength();

		for (int i = 1; i <= length; i++) {
			String query = "/entity-mappings/named-native-query[" + i + "]";

			String queryName = (String) xpath.compile(query + "/@name").evaluate(doc, XPathConstants.STRING);
			String queryValue = (String) xpath.compile(query + "/query").evaluate(doc, XPathConstants.STRING);
			String[] token = StringUtils.split(queryValue, NEW_LINE);

			sqlMap.put(queryName, token);
		}
	}
}
