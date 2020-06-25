package com.github.bakerybluprint.croissant.week_07.sh.observer_pattern_1;

public class Button {

    //notify 부분
    public void onClick() {
        //이벤트 처리
        if (onClickListener != null)
            onClickListener.onClick(this);
    }

    //Observer 부분
    public interface OnClickListener {
        //update(Target) 부분
        void onClick(Button button);
    }

    private OnClickListener onClickListener;

    //setObserver(Observer) 부분
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
