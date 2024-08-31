package org.seunga.Post.domain.content;

import org.seunga.Post.domain.common.DatetimeInfo;

public abstract class Content {
    String contentText;
    final DatetimeInfo datetimeInfo;
    public Content(String contentText){
        this.contentText = contentText;
        this.datetimeInfo = new DatetimeInfo();
    }

    public void updateContent(String updateContent){
        checkText(updateContent);
        this.contentText = updateContent;
        this.datetimeInfo.updateEditDatetime();
    }

    public String getContentText(){
        return  contentText;
    }

    protected abstract void checkText(String contentText);

    // solid 원칙. srp, ocp 원칙이 잘 지켜짐
    // srp -> 하나의 기능이 변경이 될때에는 하나의 객체만 변경이 되어야 한다.
    // ocp -> 기능이 추가가 되어도 기존 코드는 건드리지 않을 수 있음.
    // 다형성.


}
