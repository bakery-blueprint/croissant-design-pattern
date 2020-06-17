package com.github.bakerybluprint.croissant.week_07.jw.a_strategypattern;

/**
 * Project : DesignPatternReview
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:53 오후
 */
public class Client {
    public static void main(String[] args) {
        Character character = new Character(new Sword());
        character.characterAttack();
    }
}
