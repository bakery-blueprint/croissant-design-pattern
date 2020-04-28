package com.github.bakerybluprint.croissant.week_02.templatemethod.example;

/**
 * Project : croissant
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/20
 * Time : 8:51 오후
 */
public class DefaultGameConnectionHelper extends AbstractGameConnectHelper{
    @Override
    protected String doSecurity(String string) {
        System.out.println("강화된 알고리즘을 이용한 디코드...");

        return string;
    }

    @Override
    protected boolean authentication(String id, String password) {
        System.out.println("아이디/암호 확인 과정...");

        return true;
    }

    @Override
    protected int authorization(String userName) {
        System.out.println("권한 확인...");
        // TODO: [authorization] junwoochoi 2020/04/20 9:04 오후
        // 서버에서 유저 이름 혹은 유저의 나이를 알 수 있다.
        // 나이를 확인하고 시간을 확인하여 성인이 아니라면 셧 다운
        return 4;
    }

    @Override
    protected String connection(String info) {
        System.out.println("마지막 접속 단계...!");

        return info;
    }
}
