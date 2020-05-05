package com.github.bakerybluprint.croissant.week_02.jw.e_singleton.version03;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/02
 * Time : 6:30 오후
 */
public class SystemSpeaker {
    private final static SystemSpeaker INSTANCE = new SystemSpeaker();

    private SystemSpeaker() {}

    public SystemSpeaker getInstance() {

        return INSTANCE;
    }
}
