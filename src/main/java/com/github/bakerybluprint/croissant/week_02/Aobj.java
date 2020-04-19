package com.github.bakerybluprint.croissant.week_02;

/**
 * Project : croissant
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/20
 * Time : 12:59 오전
 */
public class Aobj {

    private Ainterface ainterface;

    public void setAinterface(Ainterface ainterface) {
        this.ainterface = ainterface;
    }

    public void funcAA() {
        ainterface.funcA();
        ainterface.funcA();
        /*
        System.out.println("AAA");
        System.out.println("AAA");
         */
    }
}
