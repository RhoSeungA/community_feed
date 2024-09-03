package org.seunga.Post.application.interfaces;

import org.seunga.Post.domain.Post;

import java.util.Optional;

public interface PostRepository {
    Post save(Post post);

    Optional<Post> findById(Long id);
}
