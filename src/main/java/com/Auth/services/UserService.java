package com.Auth.services;

import com.Auth.DTO.UserDTO;
import com.Auth.entities.User;
import com.Auth.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User getUserProfile(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }

    
    public User updateUser(Long userId, UserDTO userUpdateDTO) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            BeanUtils.copyProperties(userUpdateDTO, existingUser, "id", "login", "role");

            return userRepository.save(existingUser);
        } else {
        	return null;
        }
    }
}
