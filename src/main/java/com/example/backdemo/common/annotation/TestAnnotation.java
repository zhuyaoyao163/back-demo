package com.example.backdemo.common.annotation;

import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {


    /**
     *
     * @return
     */
    boolean beforeCheck() default false;
}
