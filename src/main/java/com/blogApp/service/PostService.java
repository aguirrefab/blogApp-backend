package com.blogApp.service;


import com.blogApp.entity.Post;
import com.blogApp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    public Post createPost(Post post) {
        LocalDateTime postDate = LocalDateTime.now();
        post.setDate(postDate);
        return postRepository.save(post);
    }
}
