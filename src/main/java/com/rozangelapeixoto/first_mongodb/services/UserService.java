package com.rozangelapeixoto.first_mongodb.services;

import com.rozangelapeixoto.first_mongodb.domain.User;
import com.rozangelapeixoto.first_mongodb.repository.UserRepository;
import com.rozangelapeixoto.first_mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        if(!repo.existsById(id)){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return repo.findById(id).get();
    }

}
