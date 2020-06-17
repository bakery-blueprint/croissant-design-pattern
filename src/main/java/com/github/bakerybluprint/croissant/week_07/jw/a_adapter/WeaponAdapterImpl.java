package com.github.bakerybluprint.croissant.week_07.jw.a_adapter;

/**
 * Project : DesignPatternReview
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:03 오전
 */
public class WeaponAdapterImpl implements WeaponAdapter{

    private Weapon weapon;

    public WeaponAdapterImpl(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void attack() {
        knifeAttack();
    }

    private void knifeAttack() {
        System.out.println("칼 공격");
    }
}
