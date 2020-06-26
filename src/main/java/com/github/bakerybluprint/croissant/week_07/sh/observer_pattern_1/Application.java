package com.github.bakerybluprint.croissant.week_07.sh.observer_pattern_1;

public class Application {
    public static void main(String[] args) {

        Button button = new Button();

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(Button button) {
                System.out.println(button + " is clicked.");
            }
        });
        button.onClick();
    }
}

/*
class ButtonClick implements Button.OnClickListener {

    @Override
    public void onClick(Button button) {
        System.out.println(button + " is clicked.");
    }
}
*/