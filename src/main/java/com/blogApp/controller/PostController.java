package com.blogApp.controller;

import com.blogApp.controller.rest.PostREST;
import com.blogApp.dto.PostDTO;
import com.blogApp.mapper.PostMapper;
import com.blogApp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDTO> getPost(){
        return PostMapper.INSTANCE.postsToPostDtos(postService.getPosts());
    }

    @PostMapping
    public PostDTO createPost(@RequestBody PostREST postREST){
        return postService.createPost(postREST);
    }

    @PatchMapping
    public PostDTO updatePost(@RequestBody PostREST postREST){
        return postService.updatePost(postREST);
    }

    @GetMapping("/{postId}")
    public PostDTO getPostById(@PathVariable UUID postId){
        return postService.getPostByid(postId);
    }

    @DeleteMapping("/{postId}")
    public void deletePostById(@PathVariable UUID postId){
        postService.deletePostById(postId);
    }
}
