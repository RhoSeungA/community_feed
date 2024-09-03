package org.seunga.post.domain.content;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.seunga.Post.domain.Post;
import org.seunga.Post.domain.content.PostContent;

import static org.junit.jupiter.api.Assertions.*;

public class PostContentTest{
    @Test
    void givenContentLengthIsOk_whenCreated_thenReturnTextContent(){
        //given
        String test = "this is a test";

        // when
        PostContent content = new PostContent(test);

        // then
        assertEquals(content.getContentText(),test);
    }

    @Test
    void givenContentLengthIsOver_shenCreated_thenThrowError(){
        //given
        String content = "a".repeat(501);
        //when,then
        assertThrows(IllegalArgumentException.class,()->new PostContent(content));
    }

    //@Test
    @ParameterizedTest
    @ValueSource(strings = {"뷁, 닭, 삵, 슬"})
    void givenContentLengthIsOverAndKorean_shenCreated_thenThrowError(String koreanWord){
        //given
        String content = koreanWord.repeat(501);
        //when,then
        assertThrows(IllegalArgumentException.class,()->new PostContent(content));
    }

    @Test
    void givenContentLengthIsUnder_whenCreated_thenThrowError(){
        //given
        String content = "a".repeat(4);

        // when,then
        assertThrows(IllegalArgumentException.class,()->new PostContent(content));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void givenContentIsEmpty_whenCreated_thenThrowError(String value){
        // when,then
        assertThrows(IllegalArgumentException.class,()->new PostContent(value));
    }

    @Test
    void givenContentLengthIsOver_whenUpdated_thenThrowError() {
        //given
        String content = "this is a test content";
        PostContent postContent = new PostContent(content);

        // when, then
        String value = "a".repeat(501);
        assertThrows(IllegalArgumentException.class,()->postContent.updateContent(value));

    }

    @ParameterizedTest
    @ValueSource(strings = {"뷁, 닭, 삵, 슬"})
    void givenContentLengthIsOverAndKorean_whenUpdated_thenThrowError(String koreanWord){
        //given
        String content = "this is a test content";
        PostContent postContent = new PostContent(content);

        //when, then
        String value = koreanWord.repeat(501);
        assertThrows(IllegalArgumentException.class,()->postContent.updateContent(value));
    }

    @Test
    void givenContentLengthIsUnderAndKorean_whenUpdated_thenThrowError(){
        //given
        String content = "this is a test content";
        PostContent postContent = new PostContent(content);

        //when, then
        String value = "a".repeat(4);
        assertThrows(IllegalArgumentException.class,()-> postContent.updateContent(value));
    }


}
