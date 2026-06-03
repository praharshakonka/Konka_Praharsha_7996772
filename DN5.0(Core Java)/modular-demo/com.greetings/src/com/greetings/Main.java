package com.greetings;

import com.utils.StringUtil;

public class Main {

    public static void main(String[] args) {

        String text = "hello java modules";

        System.out.println("Original: " + text);
        System.out.println("Uppercase: " + StringUtil.toUpperCase(text));
        System.out.println("Reversed: " + StringUtil.reverse(text));
    }
}