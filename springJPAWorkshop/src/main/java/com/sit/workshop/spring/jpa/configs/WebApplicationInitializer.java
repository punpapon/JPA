package com.sit.workshop.spring.jpa.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { DataAccessConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { RESTfulAppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
