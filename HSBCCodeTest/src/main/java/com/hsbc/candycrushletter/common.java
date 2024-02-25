package com.hsbc.candycrushletter;

import java.util.stream.IntStream;

public class common {

    public static final String letterChar = "abcdefghijklmnopqrstuvwxyz";

    public static String generateMixString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        try{
            buildStringBuilder(length, stringBuilder);
        }catch (Exception e){
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    private static void buildStringBuilder(int length, StringBuilder stringBuilder) {
        IntStream.range(0,length-1).forEach((e)->stringBuilder.append(letterChar.charAt((int) (Math.random() * 26))));
    }
}
