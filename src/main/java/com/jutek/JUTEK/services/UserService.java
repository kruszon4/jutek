package com.jutek.JUTEK.services;

import com.jutek.JUTEK.domain.model.UserEntity;
import com.jutek.JUTEK.domain.repositories.UserRepository;
import com.jutek.JUTEK.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public void saveUser(User user) {
        userRepository.save(mapper(user));
    }



    private UserEntity mapper(User source){

       return UserEntity.builder()
               .login(source.getLogin())
               .password(source.getPassword())
               .name(source.getName())
               .lastName(source.getLastName())
               .build();
    }



}
