package com.github.bakerybluprint.croissant.week_03.dy.example.builder02;

public class Main {

    public static void main(String[] args) {

        //  cpu, ram, storagem 순서인데 인자 순서를 잘못 넣을 수 있음!
        // Computer computer = new Computer("256 ssd", "i7", "8g");

        // 인자가 많은 경우 실수를 줄이기 위해  체이닝
        // 가독성이 높아짐!
        Computer computer = ComputerBuilder
                .start()
                .setCpu("i7")
                .setRam("8g")
                .setStorage("256 ssd")
                .build();

        System.out.print(computer.toString());
    }
}
