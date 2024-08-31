package org.seunga.Post.domain;
import org.seunga.Post.domain.content.PostContent;
import org.seunga.User.domain.User;
public class Post {
    private final Long id;
    private  final User author;
    private final PostContent postContent; // extends content ->

    public Post(Long id,User author,PostContent content){
        if(author==null){
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.author = author;
        this.postContent = content;
    }
}

/// 고민해 보아야 할것
// 1. 글쓴이의 user 객체를 가지고 있느냐. 2. Long 타입의 id 만 가지고 있느냐

// user 객체를 참조 하고 있다고 바로 알 수 있음 (가독성) 과 user 객체에 대한 기능이 생기면 메서드로 바로 사용가능
// 하지만, 테스트 세팅 번거로울 수 있음

// Long 은 나쁜 선택은 아님
// 테스트 세팅도 그렇고, 쉽게 생성이 가능

