package org.seunga.User.application;

import org.seunga.User.application.dto.CreateUserRequestDto;
import org.seunga.User.application.interfaces.UserRepository;
import org.seunga.User.domain.User;
import org.seunga.User.domain.UserInfo;

import java.util.IllformedLocaleException;

// 여기서는 비즈니스 로직을 처리하기 보다는 다른 객체와 협업을 한다.
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public User createUser(CreateUserRequestDto dto){
        UserInfo info = new UserInfo(dto.name(),dto.profileImageUrl());
        User user = new User(null,info);
        return userRepository.save(user);
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(IllformedLocaleException::new);
    }

}


// 유저와 가깝과 비즈니스로직에서 먼 -> 저수준 컴포넌트
//