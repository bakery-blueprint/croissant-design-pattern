package com.github.bakerybluprint.croissant.week_02.jw.e_singleton.version_06;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/02
 * Time : 5:53 오후
 */
public enum  SystemSpeaker {

    INSTANCE();

    SystemSpeaker() {

    }

    public static SystemSpeaker getInstance() {
        return INSTANCE;
    }

    public void innerMethod() {
        System.out.println("inner Singleton");
    }


}
