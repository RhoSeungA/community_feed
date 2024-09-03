package org.seunga.post.domain.comment;

import org.junit.jupiter.api.Test;
import org.seunga.Post.domain.Post;
import org.seunga.Post.domain.comment.Comment;
import org.seunga.Post.domain.content.CommentContent;
import org.seunga.Post.domain.content.PostContent;
import org.seunga.User.domain.User;
import org.seunga.User.domain.UserInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommentTest {
    private final User user = new User(1L, new UserInfo("name", "url"));
    private final User otherUser = new User(2L, new UserInfo("name", "url"));

    private final Post post = new Post(1L, user, new PostContent("content"));
    private final Comment comment = new Comment(1L, post, user, new CommentContent("content"));

    @Test
    void givenCommentWhenLikeThenLikeCountShouldBe1() {
        // when
        comment.like(otherUser);

        // then
        assertEquals(1, comment.getLikeCount());
    }

    @Test
    void givenCommentWhenLikeBySameUserThenLikeCountShouldThrowError() {
        // when, then
        assertThrows(IllegalArgumentException.class, () -> comment.like(user));
    }

    @Test
    void givenCommentCreatedAndLikeWhenUnlikeThenLikeCountShouldBe0() {
        // given
        comment.getLikeCount();

        // when
        comment.unlike();

        // then
        assertEquals(0, comment.getLikeCount());
    }

    @Test
    void givenCommentCreatedWhenUnlikeThenLikeCountShouldBe0() {
        // when
        comment.unlike();

        // then
        assertEquals(0, comment.getLikeCount());
    }

    @Test
    void givenCommentWhenUpdateContentThenContentShouldBeUpdated() {
        // given
        String newContent = "new content";

        // when
        comment.updateComment(user, newContent);

        // then
        assertEquals(newContent, comment.getCommentContent());
    }

    @Test
    void givenCommentWhenUpdateContentOver100ThenThrowError() {
        // given
        String newContent = "a".repeat(101);

        // when, then
        assertThrows(IllegalArgumentException.class, () -> comment.updateComment(user, newContent));
    }
}
