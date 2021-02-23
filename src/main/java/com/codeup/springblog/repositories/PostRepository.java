package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);
//    Post update(Post post);
//    Post findAll(long id);
//    Post findOnePost();
//    Post save();
//    Post deletePostBy();
}
