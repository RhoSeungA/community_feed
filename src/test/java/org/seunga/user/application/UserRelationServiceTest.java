package org.seunga.user.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.seunga.User.application.UserRelationService;
import org.seunga.User.application.UserService;
import org.seunga.User.application.dto.CreateUserRequestDto;
import org.seunga.User.application.dto.FollowUserRequestDto;
import org.seunga.User.application.interfaces.UserRelationRepository;
import org.seunga.User.application.interfaces.UserRepository;
import org.seunga.User.domain.User;
import org.seunga.user.repository.FakeUserRelationRepository;
import org.seunga.user.repository.FakeUserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRelationServiceTest {
    private  final UserRepository userRepository = new FakeUserRepository();
    private final UserService userService = new UserService(userRepository);
    private  final UserRelationRepository userRelationRepository = new FakeUserRelationRepository();
    private final UserRelationService userRelationService = new UserRelationService(userRelationRepository,userService);

    private User user1;
    private User user2;

    private FollowUserRequestDto requestDto;

    @BeforeEach
    void init(){
        CreateUserRequestDto dto = new CreateUserRequestDto("test","");
        this.user1 = userService.createUser(dto);
        this.user2 = userService.createUser(dto);
        this.requestDto = new FollowUserRequestDto(user1.getId(), user2.getId());

    }

    @Test
    void givenCreateTwoUserWhenFollowThenUserFollowOtherUser() {
        // when
        userRelationService.followUser(requestDto);

        // then
        assertEquals(1, user1.getFollowingCount());
        assertEquals(1, user2.getFollowerCount());
    }

    @Test
    void givenFollowUserWhenFollowAgainThenThrowException() {
        // given
        userRelationService.followUser(requestDto);

        // when, then
        assertThrows(IllegalArgumentException.class, () -> userRelationService.followUser(requestDto));
    }

    @Test
    void givenFollowUserWhenFollowSelfThenThrowException() {
        // given
        FollowUserRequestDto sameUser = new FollowUserRequestDto(user1.getId(), user1.getId());

        // when, then
        assertThrows(IllegalArgumentException.class, () -> userRelationService.followUser(sameUser));
    }

    @Test
    void givenFollowUserWhenUnfollowThenUserUnfollowOtherUser() {
        // given
        userRelationService.followUser(requestDto);

        // when
        userRelationService.unfollowUser(requestDto);

        // then
        assertEquals(0, user1.getFollowingCount());
        assertEquals(0, user2.getFollowerCount());
    }

    @Test
    void givenUnfollowUserWhenUnfollowAgainThenThrowException() {
        // when, then
        assertThrows(IllegalArgumentException.class, () -> userRelationService.unfollowUser(requestDto));
    }

    @Test
    void givenUnfollowUserWhenUnfollowSelfThenThrowException() {
        // given
        FollowUserRequestDto sameUser = new FollowUserRequestDto(user1.getId(), user1.getId());

        // when, then
        assertThrows(IllegalArgumentException.class, () -> userRelationService.unfollowUser(sameUser));
    }

}
