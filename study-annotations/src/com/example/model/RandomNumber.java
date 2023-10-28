package com.example.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RandomNumber {

	int min() default 1;

	int max() default 50;

	int size() default 6;

	boolean sorted() default true;

	boolean distinct() default true;

}
