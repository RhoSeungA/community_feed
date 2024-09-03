package org.seunga.Post.application;

import org.seunga.Post.application.dto.CreatePostRequestDto;
import org.seunga.Post.application.dto.LikeRequestDto;
import org.seunga.Post.application.interfaces.LikeRepository;
import org.seunga.Post.application.interfaces.PostRepository;
import org.seunga.Post.domain.Post;
import org.seunga.User.application.UserService;
import org.seunga.User.domain.User;

public class PostService {
    private final UserService userService;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    public PostService(UserService userService,PostRepository postRepository,LikeRepository likeRepository) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.likeRepository = likeRepository;
    }

    public Post getPost(Long id){
        return postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Post not found"));
    }

    public Post createPost(CreatePostRequestDto dto){
        User author = userService.getUser(dto.userId());
//        Content content = new PostContent(dto.content());
//        Post post = new Post(null,author,content,dto.state());
        Post post = Post.createPost(null,author,dto.content(),dto.state()); //
        return postRepository.save(post);
    }

    public Post updatePost(Long id,CreatePostRequestDto dto){
        Post post = getPost(id);
        User user = userService.getUser(dto.userId());
        post.updatePost(user,dto.content(),dto.state());
        return postRepository.save(post);
    }

    public void likePost(LikeRequestDto dto){
        Post post = getPost(dto.postId());
        User user = userService.getUser(dto.userId());

        if(likeRepository.checkLike(post,user)){
            return;
        }

        post.like(user);
        likeRepository.like(post,user);
    }

    public void unlikePost(LikeRequestDto dto){
        Post post = getPost(dto.postId());
        User user = userService.getUser(dto.userId());

        if(likeRepository.checkLike(post,user)){
            post.unlike();
            likeRepository.unlike(post,user);
        }


    }
}
