package com.rozangelapeixoto.first_mongodb.services;

import com.rozangelapeixoto.first_mongodb.domain.Post;
import com.rozangelapeixoto.first_mongodb.repository.PostRepository;
import com.rozangelapeixoto.first_mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;


    public Post findById(String id){
        if(!repo.existsById(id)){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return repo.findById(id).get();
    }

}
