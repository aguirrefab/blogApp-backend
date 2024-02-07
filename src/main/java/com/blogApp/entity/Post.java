package com.blogApp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Getter
@Setter
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false, unique = true)
    private UUID id;
    @Column(updatable = false, nullable = false, unique = true)
    private UUID identifier;
    private String title;
    private String category;
    private String content;
    private String author;
    private String editor;
    private LocalDateTime date;
    private LocalDateTime lastModify;


    public Post() {
    }

    public Post(String title, String category, String content, String author, String editor, LocalDateTime date, LocalDateTime lastModify) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.author = author;
        this.editor = editor;
        this.date = date;
        this.lastModify = lastModify;
    }
}
