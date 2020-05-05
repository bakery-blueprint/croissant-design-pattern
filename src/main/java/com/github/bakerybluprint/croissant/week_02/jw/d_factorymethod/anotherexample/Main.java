package com.github.bakerybluprint.croissant.week_02.jw.d_factorymethod.anotherexample;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/06
 * Time : 12:48 오전
 */
public class Main {

    public static void main(String[] args) {

        RobotFactory rf = new SuperRobotFactory();
        Robot r = rf.createRobot("super");
        Robot r2 = rf.createRobot("power");

        System.out.println(r.getName());
        System.out.println(r2.getName());

    }

}
