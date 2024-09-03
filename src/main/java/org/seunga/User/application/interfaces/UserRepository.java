package org.seunga.User.application.interfaces;

import org.seunga.User.domain.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findById(Long id);
}
