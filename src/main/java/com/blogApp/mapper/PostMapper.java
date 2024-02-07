package com.blogApp.mapper;

import com.blogApp.dto.PostDTO;
import com.blogApp.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);
    @Mapping(target = "id", ignore = true)
    Post postDTOtoPost(PostDTO postDTO);
    @Mapping(target = "postId", source = "identifier")
    PostDTO postToPostDTO(Post post);

    List<PostDTO> postsToPostDtos(List<Post> posts);
}