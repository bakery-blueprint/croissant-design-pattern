package com.github.bakerybluprint.croissant.week_03.sh.builder2;

public class Main {
    public static void main(String[] args) {
        Computer computer = ComputerBuilder
                .start()
                .setCpu("i7")
//                .setRam("16GB")
//                .setStorage("256GB SSD")
                .build();

        System.out.println(computer.toString());
    }
}
