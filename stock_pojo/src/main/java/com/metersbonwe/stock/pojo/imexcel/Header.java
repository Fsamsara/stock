package com.metersbonwe.stock.pojo.imexcel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) public @interface Header {
    String value();

    int order();
}
