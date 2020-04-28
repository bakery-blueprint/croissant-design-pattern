package com.github.bakerybluprint.croissant.week_02.templatemethod.example;



import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Project : croissant
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/20
 * Time : 8:23 오후
 */
public abstract class AbstractGameConnectHelper {

    private static final Map<Integer, String> AUTHORIZATION;

    static {
        final Map<Integer, String> authorization = new HashMap<>();
        authorization.put(0, "게임 매니저");
        authorization.put(1, "유료 회원");
        authorization.put(2, "무료 회원");
        authorization.put(3, "권한 없음");

        authorization.put(4, "Shut Down");

        AUTHORIZATION = Collections.unmodifiableMap(authorization);
    }

    /*보안 과정*/
    protected abstract String doSecurity(String string);
    /*인증 과정*/
    protected abstract boolean authentication(String id, String password);
    /*권한 과정*/
    protected abstract int authorization(String userName);
    /*접속 과정*/
    protected abstract String connection(String info);


    // 템플릿 메서드
    public String requestConnection(String encodedInfo) {
        String decodedeInfo = doSecurity(encodedInfo);
        String id = "mike6321";
        String password = "junwoo";

        if (!authentication(id, password)) {
            throw new Error("아이디 암호 불 일 치");
        }

        String userName = "userName";
        int authorization = authorization(userName);
        System.out.println(AUTHORIZATION.get(authorization));

        if (authorization == 4)
            throw new Error("셧다운!!!");


        return connection(decodedeInfo);
    }
}
