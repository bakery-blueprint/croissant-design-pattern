package com.github.bakerybluprint.croissant.week_04.jw.i_bridge;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 6:12 오후
 */
public class MorseCode {

    private MorseCodeFunction function;

    public MorseCode(MorseCodeFunction function) {
        this.function = function;
    }

    public void setFunction(MorseCodeFunction function) {
        this.function = function;
    }

    public void dot() {
        function.dot();
    }
    public void dash() {
        function.dash();
    }
    public void space() {
        function.dash();
    }

}
