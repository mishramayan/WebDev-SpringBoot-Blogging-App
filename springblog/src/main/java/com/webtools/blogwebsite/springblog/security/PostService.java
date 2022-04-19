package com.webtools.blogwebsite.springblog.security;

import com.webtools.blogwebsite.springblog.exception.PostNotFoundException;
import com.webtools.blogwebsite.springblog.dto.PostDto;
import com.webtools.blogwebsite.springblog.model.Post;
import com.webtools.blogwebsite.springblog.repository.PostRepository;
import com.webtools.blogwebsite.springblog.service.AuthService;
import io.jsonwebtoken.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private AuthService authService;

    @Autowired
    private PostRepository postRepository;

//    @Transactional
//    public void createPost(PostDto postDto){
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setContent(postDto.getContent());
//        User username = authService.getCurrentUser().orElseThrow(() ->
//            new IllegalArgumentException("No User logged in"));
//        post.setUsername(username.getUsername());
//        post.setCreatedOn(Instant.now());
//        postRepository.save(post);
//    }

    @Transactional
    public void createPost(PostDto postDto){
        Post post = mapFromPostToDto(postDto);
        postRepository.save(post);
    }

    public List<PostDto> showAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(Collectors.toList());
    }

    private PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUsername(post.getUsername());
        return postDto;
    }

    private Post mapFromPostToDto(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found!!!"));
        post.setUsername(loggedInUser.getUsername());
        post.setCreatedOn(Instant.now());
        post.setUpdatedOn(Instant.now());
        return post;
    }

    @Transactional
    public PostDto readSinglePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("For id "+id));
        return mapFromPostToDto(post);
    }
}
