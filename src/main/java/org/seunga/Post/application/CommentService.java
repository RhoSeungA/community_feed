package org.seunga.Post.application;

import org.seunga.Post.application.dto.CreateCommentRequestDto;
import org.seunga.Post.application.dto.LikeRequestDto;
import org.seunga.Post.application.dto.UpdateCommentRequestDto;
import org.seunga.Post.application.interfaces.CommentRepository;
import org.seunga.Post.application.interfaces.LikeRepository;
import org.seunga.Post.domain.Post;
import org.seunga.Post.domain.comment.Comment;
import org.seunga.User.application.UserService;
import org.seunga.User.domain.User;

public class CommentService {
    private  final UserService userService;
    private  final PostService postService;
    private final LikeRepository likeRepository;
    private  final CommentRepository commentRepository;

    public CommentService(UserService userService, PostService postService, LikeRepository likeRepository, CommentRepository commentRepository) {
        this.userService = userService;
        this.postService = postService;
        this.likeRepository = likeRepository;
        this.commentRepository = commentRepository;
    }

    public Comment getComment(Long id){
        return commentRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }
    public Comment createComment(CreateCommentRequestDto dto){
        Post post = postService.getPost(dto.postId());
        User user = userService.getUser(dto.userId());
        Comment comment = Comment.createComment(post,user,dto.content());
        return commentRepository.save(comment);
    }

    public  Comment updateComment(UpdateCommentRequestDto dto){
        Comment comment = getComment(dto.commentId());
        User user = userService.getUser(dto.userId());

        comment.updateComment(user, dto.content());
        return commentRepository.save(comment);
    }

    public void likeComment(LikeRequestDto dto){
        Comment comment = getComment(dto.targetId());
        User user = userService.getUser(dto.userId());

        if(likeRepository.checkLike(comment,user)){

        }
        comment.like(user);
        likeRepository.like(comment,user);
    }

    public void unlikeComment(LikeRequestDto dto){
        Comment comment = getComment(dto.targetId());
        User user = userService.getUser(dto.userId());

        if(likeRepository.checkLike(comment,user)){
            comment.unlike();
            likeRepository.unlike(comment,user);
        }

    }
}
