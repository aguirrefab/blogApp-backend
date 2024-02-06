package com.blogApp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDTO {

    private String title;
    private String category;
    private String content;
    private String author;
    private LocalDateTime date;
}