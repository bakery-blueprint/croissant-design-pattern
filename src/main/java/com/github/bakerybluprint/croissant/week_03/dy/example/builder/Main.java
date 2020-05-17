package com.github.bakerybluprint.croissant.week_03.dy.example.builder;

public class Main {
    public static void main(String[] args) {

        // 생성하는 것을 main class에서 하면 복잡해짐!
        // 생성하는 것을 다른 곳에서 하도록 하면 더욱 코드가 깔끔함
        // Computer computer = new Computer("i7", "16g", "256g ssd");
        // System.out.println(computer.toString());

        // 컴퓨터를 만드는 Facoty Class를 하나 만든다!
        // factory class 에서 객체생성하는 것을 넘겨줌으로서 간단하게 구현
        ComputerFactory factory = new ComputerFactory();
        factory.setBluePrint(new LgGramBluePrint());
        factory.make();
        Computer computer = factory.getComputer();
        System.out.println(computer.toString());


    }
}
