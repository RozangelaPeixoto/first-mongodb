package com.rozangelapeixoto.first_mongodb.resources;

import com.rozangelapeixoto.first_mongodb.domain.Post;
import com.rozangelapeixoto.first_mongodb.domain.User;
import com.rozangelapeixoto.first_mongodb.dto.UserDTO;
import com.rozangelapeixoto.first_mongodb.services.PostService;
import com.rozangelapeixoto.first_mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
