package com.github.bakerybluprint.croissant.week_02.strategy.example;

/**
 * Project : croissant
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/20
 * Time : 1:16 오전
 */
public class Main {
    public static void main(String[] args) {
        Character character = new Character();
        character.setWeapon(new Sword());
        character.attack();

        character.setWeapon(new Knife());
        character.attack();

        character.setWeapon(null);
        character.attack();
    }
}
