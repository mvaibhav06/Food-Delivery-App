package com.codedecode.userinfo.service;

import com.codedecode.userinfo.dto.UserDTO;
import com.codedecode.userinfo.entity.User;
import com.codedecode.userinfo.mapper.UserMapper;
import com.codedecode.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
        User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
    }

    public ResponseEntity<UserDTO> fetchUserById(int id) {
        Optional<User> fetchedUser = userRepo.findById(id);
        if (fetchedUser.isPresent()){
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(fetchedUser.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);

    }
}
