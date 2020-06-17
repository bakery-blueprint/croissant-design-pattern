package com.github.bakerybluprint.croissant.week_07.jw.a_adapter;

/**
 * Project : DesignPatternReview
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:00 오전
 */
public class Sword implements Weapon{
    @Override
    public void attack() {
        System.out.println("(Weapon) 대검 공격");
    }
}
