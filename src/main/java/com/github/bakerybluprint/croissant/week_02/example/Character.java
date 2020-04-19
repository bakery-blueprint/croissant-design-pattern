package com.github.bakerybluprint.croissant.week_02.example;

/**
 * Project : croissant
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/20
 * Time : 1:10 오전
 */
public class Character {
    private Weapon weapon;

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void attack() {
        if (weapon == null) {
            System.out.println("공격할 무기가 없습니다...");
        }else {
            weapon.attack();
        }
    }
}
