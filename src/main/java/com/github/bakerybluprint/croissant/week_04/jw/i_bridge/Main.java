package com.github.bakerybluprint.croissant.week_04.jw.i_bridge;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 6:38 오후
 */
public class Main {
    public static void main(String[] args) {
        PrintMorseCode code = new PrintMorseCode(new DefaultMorseFunction());
        code.j().u().n().w().o().o();

        System.out.println();

        code = new PrintMorseCode(new BeepMorseFunction());
        code.j().u().n().w().o().o();
    }
}
