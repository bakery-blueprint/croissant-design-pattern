package com.github.bakerybluprint.croissant.week_02.templatemethod.main;

import com.github.bakerybluprint.croissant.week_02.templatemethod.example.AbstractGameConnectHelper;
import com.github.bakerybluprint.croissant.week_02.templatemethod.example.DefaultGameConnectionHelper;

/**
 * Project : croissant
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/20
 * Time : 8:53 오후
 */
public class Main {
    public static void main(String[] args) {
        AbstractGameConnectHelper gameConnectHelper = new DefaultGameConnectionHelper();

        gameConnectHelper.requestConnection("아이디 암호 등 접속 정보");


    }
}
