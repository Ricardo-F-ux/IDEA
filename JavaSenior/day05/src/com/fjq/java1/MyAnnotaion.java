package com.fjq.java1;

import java.lang.annotation.*;

/**
 * @author EnvyFL
 * @create 2021-04-11-10:29 下午
 * @class
 */

@Inherited
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD,ElementType.PARAMETER,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
public @interface MyAnnotaion {

     String value() default "hello";

}
