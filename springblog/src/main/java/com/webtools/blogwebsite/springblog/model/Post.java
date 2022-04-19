package com.webtools.blogwebsite.springblog.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table
public class Post {

    //This Id field is the primary key for our table that's why I have used Id and Generated Annotation here
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Title should not be null and title is also a column in our table
    @NotNull
    @Column
    private String title;

    //Content should not be null, it is a large object (lob) and content is also a column in our table
    @Lob
    @Column
    @NotNull
    private String content;

    //createdOn is also a column in our table
    @Column
    private Instant createdOn;

    //updatedOn is also a column in our table
    @Column
    private Instant updatedOn;

    //username is also a column in our table, and it can't be null
    @Column
    @NotNull
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Instant updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
