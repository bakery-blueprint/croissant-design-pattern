package com.github.bakerybluprint.croissant.week_03.jw.g_builder.step03;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:14 오후
 */
public class Main {
    public static void main(String[] args) {
        ComputerBuilder builder = new ComputerBuilder.Builder()
                                                        .cpu("i7")
                                                        .ram("8GB")
                                                        .storage("256GB")
                                                        .build();

        System.out.println(builder.toString());
    }
}
