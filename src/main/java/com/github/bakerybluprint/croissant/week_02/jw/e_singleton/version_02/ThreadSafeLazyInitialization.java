package com.github.bakerybluprint.croissant.week_02.jw.e_singleton.version_02;

/**
 * Project : croissant
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/07
 * Time : 1:35 오전
 */
// TODO: [Thread safe Lazy Initialization] junwoochoi 2020/05/07 1:38 오전
public class ThreadSafeLazyInitialization {
    private static ThreadSafeLazyInitialization INSTANCE;

    private ThreadSafeLazyInitialization() {}

    public static synchronized ThreadSafeLazyInitialization getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThreadSafeLazyInitialization();
        }
        return INSTANCE;
    }
}
