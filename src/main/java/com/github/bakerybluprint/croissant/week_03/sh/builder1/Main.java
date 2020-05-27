package com.github.bakerybluprint.croissant.week_03.sh.builder1;

public class Main {
    public static void main(String[] args) {

        //1.Factory 생성
        ComputerFactory factory = new ComputerFactory();

        //2.LG그램에 해당하는 스펙의 BluePrint 설정
        factory.setBluePrint(new LgGramBluePrint());

        //3.LG그램 Computer를 make and get
        factory.make();
        Computer computer = factory.get();

        System.out.println(computer.toString());
    }
}
