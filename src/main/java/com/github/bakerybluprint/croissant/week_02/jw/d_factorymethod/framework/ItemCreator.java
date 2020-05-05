package com.github.bakerybluprint.croissant.week_02.jw.d_factorymethod.framework;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/22
 * Time : 10:29 오후
 */
public abstract class ItemCreator {

    public Item create() {
        Item item;

        //Step01
        requestItemInfo();
        //Step02
        item = createItem();
        //Step03
        createItemLog();

        return item;
    }

    //아이템을 생성하기 전에 데이터 베이스에서 아이템 정보를 요청합니다.
    abstract protected void requestItemInfo();
    //아이템을 생성 후 아이템 복제 등의 불법을 방지하기 위해 데이터 베이스에 아이템 생성
    abstract protected void createItemLog();
    //아이템을 생성하는 알고리즘
    abstract protected Item createItem();

}
