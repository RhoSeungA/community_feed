package org.seunga.Post.application.dto;

public record CreateCommentRequestDto(Long postId,Long userId,String content){
}
