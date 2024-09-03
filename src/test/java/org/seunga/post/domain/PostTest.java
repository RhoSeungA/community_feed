package org.seunga.post.domain;

import org.junit.jupiter.api.Test;
import org.seunga.Post.domain.Post;
import org.seunga.Post.domain.content.PostContent;
import org.seunga.Post.domain.content.PostPublicState;
import org.seunga.User.domain.User;
import org.seunga.User.domain.UserInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PostTest {
    private final User user = new User(1L, new UserInfo("name", "url"));
    private final User otherUser = new User(2L, new UserInfo("name", "url"));

    private final Post post = new Post(1L, user, new PostContent("content"));

    @Test
    void givenPostCreate_whenLike_ThenLikeCountShouldBe1(){
        //when
        post.like(otherUser);

        // then
        assertEquals(1,post.getLikeCount());
    }

    @Test
    void givenPostCreate_whenLikeByOtherUser_ThenThrowException(){
        // when, then
        assertThrows(IllegalArgumentException.class,()->post.like(user));
    }

    @Test
    void givenPostCreated_whenUnlike_thenLikeCountShouldBe0(){
        //when
        post.unlike();

        // then
        assertEquals(0,post.getLikeCount());
    }

    @Test
    void givenPostCreated_whenUpdateContent_thenContentShouldBeUpdate(){
        String newPostContent = "new content";

        post.updatePost(user,newPostContent, PostPublicState.PUBLIC);

        assertEquals(newPostContent,post.getPostContent());
    }

    @Test
    void givenPostCreated_whenUpdateContentOtherUser_thenContentShouldBeUpdate(){
        String newPostContent = "new content";

        post.updatePost(user,newPostContent, PostPublicState.PUBLIC);

        assertThrows(IllegalArgumentException.class,()->post.updatePost(otherUser,newPostContent, PostPublicState.PUBLIC));
    }
}
