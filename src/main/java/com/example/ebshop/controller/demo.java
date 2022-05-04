package com.example.ebshop.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Tồn tại trong lúc chạy chương trình
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD}) // Được sử dụng trên class, interface, method, biến

public @interface demo {
    String abc();
}
