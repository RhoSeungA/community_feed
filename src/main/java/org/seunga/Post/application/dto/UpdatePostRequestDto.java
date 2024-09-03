package org.seunga.Post.application.dto;

import org.seunga.Post.domain.content.PostPublicState;

public record UpdatePostRequestDto(Long postId, Long userId, String content, PostPublicState postPublicState) {
}
