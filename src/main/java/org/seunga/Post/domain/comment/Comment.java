package org.seunga.Post.domain.comment;

import org.seunga.Post.domain.Post;
import org.seunga.Post.domain.content.Content;
import org.seunga.User.domain.User;
import org.seunga.common.domain.PositiveIntegerCounter;

public class Comment {
    private  final Long id;
    private  final Post post;
    private  final User author;
    private  final Content content;
    private  final PositiveIntegerCounter likeCount;

    public Comment(Long id, Post post, User author, Content content) {
        if(post == null) throw  new IllegalArgumentException();
        if(author == null) throw  new IllegalArgumentException();
        if(content == null) throw  new IllegalArgumentException();

        this.id = id;
        this.post = post;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();

    }
    public void like(User user){
        if(this.author.equals(user)){
            throw new IllegalArgumentException();
        }
        likeCount.increase();// 이 메서드 안에서 검증하고, 예외처리
    }

    public void unlike(User user){
        this.likeCount.decrease();
    }
}
