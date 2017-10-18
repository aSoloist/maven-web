package com.ly.annotation;

import java.lang.annotation.*;

/**
 * Created by ly on 2017/10/18 21:30
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginNotRequired {
}
