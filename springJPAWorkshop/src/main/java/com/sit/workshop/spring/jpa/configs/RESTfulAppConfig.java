package com.sit.workshop.spring.jpa.configs;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Configuration
@EnableWebMvc
@ComponentScans(value = {
		  @ComponentScan(basePackages = "com.sit.workshop.spring.jpa.apis.security")
		, @ComponentScan(basePackages ="com.sit.workshop.spring.jpa.apis.immigration")
})
public class RESTfulAppConfig implements WebMvcConfigurer {

	/**
	 * Configure the MappingJackson2HttpMessageConverter to use for reading or
	 * writing to the body of the request or response.
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		try {
			Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	        builder.indentOutput(true);
	        builder.serializationInclusion(Include.NON_NULL);
	        
	        MappingJackson2HttpMessageConverter converter = 
					new MappingJackson2HttpMessageConverter(builder.build());
	        converter.setDefaultCharset(StandardCharsets.UTF_8);
	        converters.add(converter);

			WebMvcConfigurer.super.configureMessageConverters(converters);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
