package com.github.bakerybluprint.croissant.week_02.jw.e_singleton.version_05;

/**
 * Project : croissant
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/07
 * Time : 1:25 오전
 */
// TODO: [LazyHolder] junwoochoi 2020/05/07 1:41 오전
// 
public class Singleton {
    private Singleton() {
        if (true)
            throw  new UnsupportedOperationException();
    }

    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
}
