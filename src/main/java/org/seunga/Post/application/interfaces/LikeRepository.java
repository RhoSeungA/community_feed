package org.seunga.Post.application.interfaces;

import org.seunga.Post.domain.Post;
import org.seunga.Post.domain.comment.Comment;
import org.seunga.User.domain.User;

public interface LikeRepository {
    boolean checkLike(Post post, User user);
    void like(Post post,User user);
    void unlike(Post post,User user);

    boolean checkLike(Comment comment, User user);
    void like(Comment post,User user);
    void unlike(Comment post,User user);
}
