package com.github.bakerybluprint.croissant.week_02.jw.d_factorymethod;


import com.github.bakerybluprint.croissant.week_02.jw.d_factorymethod.concrete.HpCreator;
import com.github.bakerybluprint.croissant.week_02.jw.d_factorymethod.concrete.MpCreator;
import com.github.bakerybluprint.croissant.week_02.jw.d_factorymethod.framework.Item;
import com.github.bakerybluprint.croissant.week_02.jw.d_factorymethod.framework.ItemCreator;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/22
 * Time : 10:55 오후
 */
public class Main {
    public static void main(String[] args) {
        Item item;
        ItemCreator itemCreator;

        itemCreator = new HpCreator();
        item = itemCreator.create();
        item.use();

        itemCreator = new MpCreator();
        item = itemCreator.create();
        item.use();

    }
}
