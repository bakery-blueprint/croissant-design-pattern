package com.github.bakerybluprint.croissant.week_07.jw.n_chainofresponsibility;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:33 오후
 */
public class Main {
    public static void main(String[] args) {
        Calulator plus = new PlusCalulator();
        Calulator sub = new SubCalulator();
        plus.setNextCalculator(sub);
        Request request1 = new Request(1,2,"+");
        Request request2 = new Request(10,2,"-");
        plus.process(request1);
        plus.process(request2);
    }
}

