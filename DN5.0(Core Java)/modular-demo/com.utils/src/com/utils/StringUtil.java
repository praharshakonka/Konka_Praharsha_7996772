package com.utils;

public class StringUtil {

    public static String toUpperCase(String input) {
        return input.toUpperCase();
    }

    public static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}