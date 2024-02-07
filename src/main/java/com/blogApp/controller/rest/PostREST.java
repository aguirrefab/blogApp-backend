package com.blogApp.controller.rest;

import lombok.Data;

import java.util.UUID;

@Data
public class PostREST {
    private UUID identifier;
    private String title;
    private String category;
    private String content;
    private String author;
    private String editor;
}
