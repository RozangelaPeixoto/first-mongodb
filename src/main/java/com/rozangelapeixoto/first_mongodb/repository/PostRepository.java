package com.rozangelapeixoto.first_mongodb.repository;

import com.rozangelapeixoto.first_mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}