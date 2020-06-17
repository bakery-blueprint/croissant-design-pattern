package com.github.bakerybluprint.croissant.week_07.jw.n_chainofresponsibility;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:33 오후
 */
public class PlusCalulator extends Calulator {
    @Override
    protected boolean operator(Request request) {

        if(request.getOperator().equals("+")) {
            int a = request.getA();
            int b = request.getB();
            System.out.println(a + "+"+b + "= " +(a+b));
        }
        return false;
    }
}
