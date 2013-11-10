package com.fcloud.web.page;

import com.fcloud.core.model.Sort;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Ruben Fu
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface PageableDefaults {

    int value() default 20;

    int pageNumber() default 0;

    String[] sort() default {};

    Sort.Direction sortDir() default Sort.Direction.ASC;
}
