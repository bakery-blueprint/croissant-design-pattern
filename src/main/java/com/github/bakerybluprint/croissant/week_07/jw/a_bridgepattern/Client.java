package com.github.bakerybluprint.croissant.week_07.jw.a_bridgepattern;

/**
 * Project : DesignPatternReview
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:19 오전
 */
public class Client {
    public static void main(String[] args) {
        Weapon weapon = new Knife();
        weapon.attack();
        weapon.repair();

        WeaponHandler weaponHandler = new Character1(weapon);
        weaponHandler.handle();

    }
}
