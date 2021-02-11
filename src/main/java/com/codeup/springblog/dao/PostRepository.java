package com.codeup.springblog.dao;

import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findAllPosts(); // select * from posts where title = ?;
    Post findOnePost();
    Post save();
    Post deletePostBy();
}
