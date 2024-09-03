package org.seunga.user.domain;

import org.junit.jupiter.api.Test;
import org.seunga.User.domain.UserInfo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserInfoTest {
    // 작은 객체 테스트
    @Test
    void givennameAndProfileImage_whenCreated_thenThrowNothing(){
        // given
        String name= "abcd";
        String profileImageUrl = "";

        // when

        // then
        assertDoesNotThrow(()-> new UserInfo(name,profileImageUrl));
    }

    @Test
    void givenNameAndProfileImage_whenCreated_thenThrowError(){
        // given
        String name= "";
        String profileImageUrl = "";

        // when

        // then
        assertThrows(IllegalArgumentException.class,()-> new UserInfo(name,profileImageUrl));
    }
}

