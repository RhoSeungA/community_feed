package org.seunga.Post.application.dto;

public record UpdateCommentRequestDto(Long commentId,Long userId,String content) {

}
