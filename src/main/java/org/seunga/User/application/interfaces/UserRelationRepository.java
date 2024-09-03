package org.seunga.User.application.interfaces;

import org.seunga.User.domain.User;

public interface UserRelationRepository {
    boolean isAlreadyFollow(User user, User targetUser);
    void save(User user, User targetUser);
    void delete(User user, User targetUser);

    //user 전체를 넘기는 이유는 ?
    // -> 변경이 있는 도메인 객체 전체를 던지는 것을 더 선호. 이유는 user의 countㄷ 같이 업데이트 되어야 하기 때문.
    // 트랜잭션 단위로 변경이 일어나야 하는 것들은 같이 메소드 하나로 묶어주면 유지 보수가 쉬워지는 장점
    // 만약 userid를 던지면 , select르 ㄹ한번더 하거나, 내부적으로 user들의 count를 한번더 가져와야하거나..아니면 메소드를 넘겨줘야하는 추가적인 유즈 정보들이 있다면
    // 매번 인터페이스 변경이 일어남
    // user 객체를 넘기면 ---> 유저 내부만 변경을 해도 인터페이스에는 변화 없음
}
