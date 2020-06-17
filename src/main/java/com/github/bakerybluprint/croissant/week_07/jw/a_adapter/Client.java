package com.github.bakerybluprint.croissant.week_07.jw.a_adapter;

/**
 * Project : DesignPatternReview
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:02 오전
 */
public class Client {
    public static void main(String[] args) {
        Weapon weapon = new Sword();
        weapon.attack();

        // TODO: [main] junwoochoi 2020/06/16 12:05 오전
        // 갑자기 칼공격으로 바꾸고 싶다....


        WeaponAdapterImpl weaponAdapter = new WeaponAdapterImpl(new Sword());
        weaponAdapter.attack();
    }
}
