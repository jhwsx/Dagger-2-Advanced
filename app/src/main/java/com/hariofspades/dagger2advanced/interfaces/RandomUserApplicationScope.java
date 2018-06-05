package com.hariofspades.dagger2advanced.interfaces;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author wzc
 * @date 2018/6/4
 */
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface RandomUserApplicationScope {
}
