package com.cyb.tms.entity.base;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BaseEntity implements Serializable {
	
	@Override
	 public String toString() {
	    return ReflectionToStringBuilder.toString(this);
	 }

}
