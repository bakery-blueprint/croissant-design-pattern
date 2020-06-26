package com.github.bakerybluprint.croissant.week_07.sh.observer_pattern_3;

public class Application {

    public static void main(String[] args) {
        //1. 제네릭
        //2. 델리게이트
        //3. 내부에 Observer 넣음

        Button button = new Button();
        button.addObserver(new Observable.Observer<String>() {
            @Override
            public void update(Observable<String> o, Object arg) {
                System.out.println(o + " is clicked.");
            }
        });
        button.onClick();
        button.onClick();
        button.onClick();
    }
}
