package com.github.bakerybluprint.croissant.week_07.jw.a_bridgepattern;

/**
 * Project : DesignPatternReview
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:18 오전
 */
public class Character2 implements WeaponHandler{

    private Weapon weapon;

    public Character2(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void handle() {
        System.out.println("Character2");
        weapon.repair();
    }
}
