package com.codingbz.CodingBZ.Service;

import com.codingbz.CodingBZ.DTOs.UserRelatedDTOs.UserDetailsDTO;
import com.codingbz.CodingBZ.DTOs.UserRelatedDTOs.UserLoginDTo;
import com.codingbz.CodingBZ.DTOs.UserRelatedDTOs.UserSignupDTO;
import com.codingbz.CodingBZ.Model.User;
import com.codingbz.CodingBZ.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public void signUp(UserSignupDTO userSignupDTO) {
        if (userRepository.findByUsername(userSignupDTO.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exists");
        }

        // Perform any additional validation or processing
        User user = new User();
        user.setName(userSignupDTO.getName());
        user.setUsername(userSignupDTO.getUsername());
        user.setPassword(userSignupDTO.getPassword());
        userRepository.save(user);
    }

    public void login(UserLoginDTo userLoginDTo) {
        User existingUser = userRepository.findByUsername(userLoginDTo.getUsername());

        if (existingUser == null || !existingUser.getPassword().equals(userLoginDTo.getPassword())) {
            throw new IllegalArgumentException("Invalid username or password");
        }

        // Perform any additional processing
    }

    public void addUserDetails(UserDetailsDTO userDetailsDTO){
        User user = new User();
        user.setUsername(userDetailsDTO.getUsername());
        user.setPassword(userDetailsDTO.getPassword());
        user.setEmail(userDetailsDTO.getEmail());
        user.setName(userDetailsDTO.getName());
        user.setMobile_number(userDetailsDTO.getMobile_number());
        user.setWhatsapp_number(userDetailsDTO.getWhatsapp_number());
        user.setAddress(userDetailsDTO.getAddress());

        userRepository.save(user);
    }

    public void deleteUserDetails(String username){
       User user = userRepository.findByUsername(username);
       userRepository.delete(user);
    }

    public void updateUserDetails(String username,UserDetailsDTO userDetailsDTO ){
        User user = userRepository.findByUsername(username);

        user.setEmail(userDetailsDTO.getEmail());
        user.setName(userDetailsDTO.getName());
        user.setMobile_number(userDetailsDTO.getMobile_number());
        user.setWhatsapp_number(userDetailsDTO.getWhatsapp_number());
        user.setAddress(userDetailsDTO.getAddress());

        userRepository.save(user);
    }
    public User getUserAccountDetails(String username){
        return userRepository.findByUsername(username);
    }
}
