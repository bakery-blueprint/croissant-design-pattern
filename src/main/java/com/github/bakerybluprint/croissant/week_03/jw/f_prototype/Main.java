package com.github.bakerybluprint.croissant.week_03.jw.f_prototype;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/03
 * Time : 11:44 오후
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Circle circle1 = new Circle(1,1,3);
        Circle circle2 = circle1.copy();

        System.out.println(circle1.toString());
        System.out.println(circle2.toString());

    }
}
