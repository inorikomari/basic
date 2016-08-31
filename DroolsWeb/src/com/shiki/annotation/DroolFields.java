package com.shiki.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DroolFields {
	boolean dict() default false; //是否评分字段
	
	boolean isgrade() default false;
	
	String describ(); // 字段描述

	String column(); // 字段code
	
	String url() default "none";
	
	String getMethod() default "none";
	
	String setMethod() default "none";
	
}
