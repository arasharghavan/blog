package com.example.blog;

import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository<Post,Long> {
//                                 post comes from java class    becuse id in Post class is Lonf
    //its gonna be same
}
