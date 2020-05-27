package com.github.bakerybluprint.croissant.week_03.jw.g_builder.step02;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:43 오후
 */
public class Main {
    public static void main(String[] args) {
        Computer computer = ComputerBuilder
                                .start()
                                .setCpu("i7")
                                .setRam("8g")
                                .setStorage("256G SSD")
                                .build();

        System.out.println(computer.toString());
    }
}
