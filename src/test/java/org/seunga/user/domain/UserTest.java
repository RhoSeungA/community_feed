package org.seunga.user.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.seunga.User.domain.User;
import org.seunga.User.domain.UserInfo;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private  final UserInfo userInfo= new UserInfo("test","");
    private User user1 = new User(1L,userInfo);
    private User user2 = new User(2L,userInfo);

    @BeforeEach
    void init(){
        user1= new User(1L,userInfo);
        user2= new User(2L,userInfo);
    }
    @Test
    void givenTwoUser_whenEqual_thenReturnFalse(){
        //when
        boolean value = user1.equals(user2);
        //then
        assertFalse(value);


    }

    @Test
    void givenTwoSameIdUser_whenEqual_thenReturnFalse(){
        // given
        User sameUser = new User(1L,userInfo);


        //when
        boolean isSame = user1.equals(sameUser);

        //then
        assertTrue(isSame);
    }

    @Test
    void givenTwoUser_whenHashCode_thenReturnFalse(){
        // when
        int hashcode1= user1.hashCode();
        int hashcode2= user2.hashCode();

        //then
        assertNotEquals(hashcode1,hashcode2);
    }

    @Test
    void givenTwoSameIdUser_whenHashCode_thenEqual(){
        // given
        User sameUser = new User(1L,userInfo);

        // when
        int hashcode1= user1.hashCode();
        int sameUserHashcode= sameUser.hashCode();

        //then
        assertEquals(hashcode1,sameUserHashcode);
    }


    @Test
    void givenTwoUser_whenUser1FollowUser2_thenIncreasedUserCount(){
        // given

        // when
        user1.follow(user2);

        //then
        assertEquals(1, user1.getFollowingCount());
        assertEquals(0, user1.getFollowerCount());
        assertEquals(0, user2.getFollowingCount());
        assertEquals(1, user2.getFollowerCount());

    }

    @Test
    void givenTwoUserUser1FollowUser2_whenUser1UnfollowUser2_thenDecreaseUserCount(){
        // given
        user1.follow(user2);

        // when
        user1.unfollow(user2);

        //then
        assertEquals(0, user1.getFollowingCount());
        assertEquals(0, user1.getFollowerCount());
        assertEquals(0, user2.getFollowingCount());
        assertEquals(0, user2.getFollowerCount());

    }

    @Test
    void givenTwoUser_whenUnfollow_thenNotDecreaseUserCount() {
        //when
        user1.unfollow(user2);

        // then
        assertEquals(0, user1.getFollowingCount());
        assertEquals(0, user1.getFollowerCount());
        assertEquals(0, user2.getFollowingCount());
        assertEquals(0, user2.getFollowerCount());
    }






}
