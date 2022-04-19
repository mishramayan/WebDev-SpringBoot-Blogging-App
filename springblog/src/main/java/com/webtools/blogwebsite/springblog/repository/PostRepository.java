package com.webtools.blogwebsite.springblog.repository;

import com.webtools.blogwebsite.springblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {


}
