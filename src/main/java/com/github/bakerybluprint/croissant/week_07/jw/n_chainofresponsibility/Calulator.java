package com.github.bakerybluprint.croissant.week_07.jw.n_chainofresponsibility;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:32 오후
 */
public abstract class Calulator {
    private Calulator nextCalculator;
    public void setNextCalculator(Calulator calulator) {
        this.nextCalculator = calulator;
    }
    public boolean process(Request request) {
        if (operator(request)){
            return true;
        }else {
            if (nextCalculator != null) {
                return nextCalculator.process(request);
            }
        }
        return false;
    }
    abstract protected boolean operator(Request request);
}
