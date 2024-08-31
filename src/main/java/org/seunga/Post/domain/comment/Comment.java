package org.seunga.Post.domain.comment;

import org.seunga.Post.domain.Post;
import org.seunga.Post.domain.content.Content;
import org.seunga.User.domain.User;

public class Comment {
    private  final Long id;
    private  final Post post;
    private  final User author;
    private  final Content content;

    public Comment(Long id, Post post, User author, Content content) {
        if(post == null) throw  new IllegalArgumentException();
        if(author == null) throw  new IllegalArgumentException();
        if(content == null) throw  new IllegalArgumentException();

        this.id = id;
        this.post = post;
        this.author = author;
        this.content = content;

    }
}
