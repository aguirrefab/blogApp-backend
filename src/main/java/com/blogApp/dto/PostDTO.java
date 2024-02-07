package com.blogApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class PostDTO {
    private UUID postId;
    private String title;
    private String category;
    private String content;
    private String author;
    private String editor;
    private LocalDateTime date;
    private LocalDateTime lastModify;

    public PostDTO() {

    }
}