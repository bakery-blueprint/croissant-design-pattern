package com.github.bakerybluprint.croissant.week_02.jw.e_singleton.version_01;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/02
 * Time : 6:30 오후
 */
// TODO: [Eager initialization] junwoochoi 2020/05/07 1:33 오전
public class EagarInitialization {
    private final static EagarInitialization INSTANCE = new EagarInitialization();

    private EagarInitialization() {}

    public static EagarInitialization getInstance() {

        return INSTANCE;
    }
}
