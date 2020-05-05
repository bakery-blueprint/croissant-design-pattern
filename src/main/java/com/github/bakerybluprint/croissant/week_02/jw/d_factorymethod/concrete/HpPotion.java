package com.github.bakerybluprint.croissant.week_02.jw.d_factorymethod.concrete;


import com.github.bakerybluprint.croissant.week_02.jw.d_factorymethod.framework.Item;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/22
 * Time : 10:45 오후
 */
public class HpPotion implements Item {
    @Override
    public void use() {
        System.out.println("체력 회복!");
    }
}
