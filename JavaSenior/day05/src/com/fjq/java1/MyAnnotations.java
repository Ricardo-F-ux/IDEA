package com.fjq.java1;

import java.lang.annotation.*;

/**
 * @author EnvyFL
 * @create 2021-04-11-11:05 下午
 * @class
 */
@Inherited
@Target({ElementType.TYPE, ElementType.FIELD,ElementType.PARAMETER,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations {
    MyAnnotaion [] value();
}
