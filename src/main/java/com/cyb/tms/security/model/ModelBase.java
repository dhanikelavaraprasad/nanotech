package com.cyb.tms.security.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ModelBase implements Serializable {

	@Override
	  public String toString() {
	    return ReflectionToStringBuilder.toString(this);
	}
}
