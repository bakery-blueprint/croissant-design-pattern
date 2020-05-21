package com.github.bakerybluprint.croissant.week_03.sh.builder1;

public class Main {
    public static void main(String[] args) {

        ComputerFactory factory = new ComputerFactory();

        factory.setBluePrint(new LgGramBluePrint());

        factory.make();

        Computer computer = factory.get();

        System.out.println(computer.toString());
    }
}
