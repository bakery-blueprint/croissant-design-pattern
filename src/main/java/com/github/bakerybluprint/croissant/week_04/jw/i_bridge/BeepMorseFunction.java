package com.github.bakerybluprint.croissant.week_04.jw.i_bridge;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:38 오후
 */
public class BeepMorseFunction implements MorseCodeFunction{
    @Override
    public void dot() {
        System.out.print("(Beep) .");
    }

    @Override
    public void dash() {
        System.out.print("(Beep) -");
    }

    @Override
    public void space() {
        System.out.print("(Beep)  ");
    }
}
