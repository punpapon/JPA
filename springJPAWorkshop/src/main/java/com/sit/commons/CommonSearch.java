package com.sit.commons;

import java.io.Serializable;
import java.math.BigDecimal;

public class CommonSearch implements Serializable {
	private static final long serialVersionUID = 7900491670579462828L;
	
	private BigDecimal id;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}
}
