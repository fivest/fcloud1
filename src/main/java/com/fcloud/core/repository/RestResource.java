package com.fcloud.core.repository;

import java.lang.annotation.*;

/**
 * @author Ruben Fu
 */
@Target({
    ElementType.FIELD,
    ElementType.METHOD,
    ElementType.TYPE
})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RestResource {
    String path();
}
