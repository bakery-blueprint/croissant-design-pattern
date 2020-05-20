package com.github.bakerybluprint.croissant.week_03.jw.g_builder.step01;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:25 오후
 */
public class Main {
    public static void main(String[] args) {

        ComputerFactory factory = new ComputerFactory();

        factory.setBlueprint(new LgGramBlueprint());
        factory.make();

        Computer computer =  factory.getComputer();


        System.out.println(computer.toString());

    }
}
