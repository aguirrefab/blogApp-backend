package com.blogApp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String category;
    private String content;
    private String author;
    private LocalDateTime date;

    public Post() {
    }
    public Post(String title, String category, String content, String author, LocalDateTime date) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.author = author;
        this.date = date;
    }
}
