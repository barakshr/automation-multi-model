package com.team.selenium.controls.api;


import com.team.selenium.controls.elements.ControlImpl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ImplementedBy {

    Class<?> value() default ControlImpl.class;

}
