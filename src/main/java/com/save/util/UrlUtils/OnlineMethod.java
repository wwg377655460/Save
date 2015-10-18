package com.save.util.UrlUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 在线文档的方法注解
 *
 * @author WSD
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface OnlineMethod {

    String memo();

    String param();

    String method();

    String url();

    int type();


}
