package com.jutek.JUTEK.services;

import com.jutek.JUTEK.domain.model.UserEntity;
import com.jutek.JUTEK.domain.repositories.UserRepository;
import com.jutek.JUTEK.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public void saveUser(User user) {
        userRepository.save(mapper(user));
    }

    public List<String> getAllUser() {
        return userRepository.findAll().stream().map(UserEntity::getName).collect(Collectors.toList());
    }


    public String getUserById(Long id){

        UserEntity userEntity = userRepository.findById(id).get();

        return userEntity.getName() + " " + userEntity.getLastName();
    }

    public List<User> getAllUserData() {
        return userRepository.findAll().stream().map(this::mapper).collect(Collectors.toList());
    }
    private UserEntity mapper(User source) {

        return UserEntity.builder()
                .login(source.getLogin())
                .password(source.getPassword())
                .name(source.getName())
                .lastName(source.getLastName())
                .build();
    }

    private User mapper(UserEntity source) {

        return User.builder()
                .login(source.getLogin())
                .password(source.getPassword())
                .name(source.getName())
                .lastName(source.getLastName())
                .userID(String.valueOf(source.getUserId()))
                .build();
    }


}
