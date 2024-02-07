package com.blogApp.service;

import com.blogApp.controller.rest.PostREST;
import com.blogApp.dto.PostDTO;
import com.blogApp.entity.Post;

import com.blogApp.mapper.PostMapper;
import com.blogApp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

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

    public PostDTO createPost(PostREST postREST) {
        if(postREST != null) {
            Post newPost = new Post();
            newPost.setDate(LocalDateTime.now());
            newPost.setCategory(postREST.getCategory());
            newPost.setAuthor(postREST.getAuthor());
            newPost.setContent(postREST.getContent());
            newPost.setTitle(postREST.getTitle());

            // Generate UUID for the identifier field
            newPost.setIdentifier(UUID.randomUUID());

            return PostMapper.INSTANCE.postToPostDTO(postRepository.save(newPost));
        } else {
            throw new IllegalArgumentException("Post cannot be null");
        }
    }

    public PostDTO updatePost(PostREST postREST) {
        if(postREST.getIdentifier() != null) {
            Post postToUpdate = postRepository.findByIdentifier(postREST.getIdentifier());

            if(postToUpdate != null) {
                postToUpdate.setLastModify(LocalDateTime.now());
                postToUpdate.setCategory(postREST.getCategory());
                postToUpdate.setTitle(postREST.getTitle());
                postToUpdate.setEditor(postREST.getEditor());
                postToUpdate.setContent(postREST.getContent());
                return PostMapper.INSTANCE.postToPostDTO(postRepository.save(postToUpdate));
            } else {
                throw new NoSuchElementException("Not found Post with identifier provided");
            }
        } else {
            throw new IllegalArgumentException("Post identifier to update cannot be null");
        }
    }

    public PostDTO getPostByid(UUID postId) {
        return PostMapper.INSTANCE.postToPostDTO(postRepository.findByIdentifier(postId));
    }

    public void deletePostById(UUID postId){
        Post postToUpdate = postRepository.findByIdentifier(postId);
        if(postToUpdate != null) {
            postRepository.deleteById(postToUpdate.getId());
        } else {
            throw new IllegalArgumentException("Post identifier to delete cannot be null");
        }
    }
}
