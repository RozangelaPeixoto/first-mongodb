package com.rozangelapeixoto.first_mongodb.services;

import com.rozangelapeixoto.first_mongodb.domain.Post;
import com.rozangelapeixoto.first_mongodb.repository.PostRepository;
import com.rozangelapeixoto.first_mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    /*public List<Post> findByTitle(String text) {
        return repo.findByTitleContainingIgnoreCase(text);
    }*/
    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}
