package org.seunga.user.application;

import org.junit.jupiter.api.Test;
import org.seunga.User.application.UserService;
import org.seunga.User.application.dto.CreateUserRequestDto;
import org.seunga.User.application.interfaces.UserRepository;
import org.seunga.User.domain.User;
import org.seunga.User.domain.UserInfo;
import org.seunga.user.repository.FakeUserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {
    private  final UserRepository userRepository = new FakeUserRepository();
    private final UserService userService = new UserService(userRepository);

    @Test
    void giveUserInfoDto_whenCreateUser_thenCanFindUser(){
        //given
        CreateUserRequestDto dto= new CreateUserRequestDto("test","");

        //when
        User savedUser = userService.createUser(dto);

        //then
        User foundUser = userService.getUser(savedUser.getId());
        UserInfo userInfo = foundUser.getUserInfo();
        assertEquals(foundUser.getId(),savedUser.getId());
        assertEquals("test",userInfo.getName());

    }

}
