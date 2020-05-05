package com.github.bakerybluprint.croissant.week_02.jw.f_prototype;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/03
 * Time : 11:42 오후
 */
public class Circle extends Shape{

    private int x;
    private int y;
    private int r;


    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }

    public Circle copy() throws CloneNotSupportedException {

        Circle clone = (Circle) clone();
        clone.x = x + 1;
        clone.y = y + 1;


        return clone;
    }
}
