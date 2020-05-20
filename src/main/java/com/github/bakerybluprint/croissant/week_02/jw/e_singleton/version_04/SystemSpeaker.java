package com.github.bakerybluprint.croissant.week_02.jw.e_singleton.version_04;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/27
 * Time : 10:58 오후
 */
public class SystemSpeaker {
    private static SystemSpeaker instance;
    private int volume;

    private SystemSpeaker() {

    }

    public static SystemSpeaker getInstance() {

        if (instance == null) {
            instance = new SystemSpeaker();
        }

        return instance;
    }

    public int getVolume() {
        return volume;
   }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}