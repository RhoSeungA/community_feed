package org.seunga.common.domain;

/// post 와 content 에서 사용하므로 commont 패키지로 이동
public class PositiveIntegerCounter {
    private int count;

    public PositiveIntegerCounter(){
        this.count=0;
    }
    public  void increase(){
        this.count++;
    }

    public void decrease(){
        if(count<=0){
            return;
        }
        this.count--;
    }

    public int getCount(){
        return this.count;
    }
}
