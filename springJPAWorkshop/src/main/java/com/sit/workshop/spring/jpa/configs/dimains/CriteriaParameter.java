package com.sit.workshop.spring.jpa.configs.dimains;

public class CriteriaParameter {
	private String name;
	private Object data;
	private boolean hadParameter;

	public CriteriaParameter(String name, Object data) {
		this.name = name;
		this.data = data;
		this.hadParameter = false;
	}

	public String getName() {
		return name;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}
	
	public boolean isHadParameter() {
		return hadParameter;
	}

	public void setHadParameter(boolean hadParameter) {
		this.hadParameter = hadParameter;
	}

}
