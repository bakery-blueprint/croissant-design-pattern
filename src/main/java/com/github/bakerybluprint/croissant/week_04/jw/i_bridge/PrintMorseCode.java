package com.github.bakerybluprint.croissant.week_04.jw.i_bridge;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper * @comment :
 * Time : 6:34 오후
 */
public class PrintMorseCode extends MorseCode{

    public PrintMorseCode(MorseCodeFunction function) {
        super(function);
    }

    public PrintMorseCode j() {
        dot();
        dash();
        dash();
        dash();
        space();

        return this;
    }
    public PrintMorseCode u() {
        dot();
        dot();
        dash();
        space();

        return this;
    }
    public PrintMorseCode n() {
        dash();
        dot();
        space();

        return this;
    }
    public PrintMorseCode w() {
        dot();
        dash();
        dash();
        space();

        return this;
    }
    public PrintMorseCode o() {
        dash();
        dash();
        dash();
        space();

        return this;
    }

}
