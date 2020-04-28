package com.github.bakerybluprint.croissant.week_02.strategy;

/**
 * Project : croissant
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/20
 * Time : 12:58 오전
 */
public class Main {
    public static void main(String[] args) {
        // TODO: [main] junwoochoi 2020/04/20 1:04 오전
        // 선언과 구현을 분리
        Ainterface ainterface = new AinterfaceImpl();
        ainterface.funcA();

        // TODO: [main] junwoochoi 2020/04/20 1:04 오전
        // 위임
        Aobj aobj = new Aobj();
        aobj.setAinterface(new AinterfaceImpl());
        aobj.funcAA();


    }
}
