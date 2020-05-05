package com.github.bakerybluprint.croissant.week_02.jw.d_factorymethod.concrete;


import com.github.bakerybluprint.croissant.week_02.jw.d_factorymethod.framework.Item;
import com.github.bakerybluprint.croissant.week_02.jw.d_factorymethod.framework.ItemCreator;

import java.util.Date;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/22
 * Time : 10:46 오후
 */
public class MpCreator extends ItemCreator {
    @Override
    protected void requestItemInfo() {
        System.out.println("데이터 베이스에서 마력 회복 물약의 터정보를 가져옵니다.");
    }

    @Override
    protected void createItemLog() {
        System.out.println("마력 회복 물약을 새로 생성 했습니다."+new Date());
    }

    @Override
    protected Item createItem() {
        
        return new MpPotion();
    }
}
