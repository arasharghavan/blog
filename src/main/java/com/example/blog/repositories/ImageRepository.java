package com.example.blog.repositories;

import com.example.blog.models.PostImage;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<PostImage ,Long> {
}
