package org.seunga.Post.application.dto;

import org.seunga.Post.domain.content.PostPublicState;

public record CreatePostRequestDto(Long userId, String content, PostPublicState state) {
}
