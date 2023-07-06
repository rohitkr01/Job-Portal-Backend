package com.codingbz.CodingBZ.Controller;

import com.codingbz.CodingBZ.DTOs.UserRelatedDTOs.UserDetailsDTO;
import com.codingbz.CodingBZ.DTOs.UserRelatedDTOs.UserLoginDTo;
import com.codingbz.CodingBZ.DTOs.UserRelatedDTOs.UserSignupDTO;
import com.codingbz.CodingBZ.Model.User;
import com.codingbz.CodingBZ.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Replace with the actual React application URL
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserSignupDTO userSignupDTO) {
        try {
            userService.signUp(userSignupDTO);
            return ResponseEntity.ok("User registered successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTo userLoginDTo) {
        try {
            userService.login(userLoginDTo);
            return ResponseEntity.ok("Login successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/add-user")
    public ResponseEntity<?> addUserDetails(@RequestBody UserDetailsDTO userDetailsDTo) {
        try {
            userService.addUserDetails(userDetailsDTo);
            return ResponseEntity.ok("User Added successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/delete-user/{username}")
    public ResponseEntity<?> deleteUserDetails(@PathVariable String username) {
        try {
            userService.deleteUserDetails(username);
            return ResponseEntity.ok("User Added successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/update-user/{username}")
    public ResponseEntity<?> updateUserDetails(@PathVariable String username, @RequestBody UserDetailsDTO userDetailsDTO){
        try{
            userService.updateUserDetails(username, userDetailsDTO);
            return ResponseEntity.ok("User updated successful");
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/{username}")
    public ResponseEntity<?> userAccountDetails(@PathVariable String username) {
        try {
            User response = userService.getUserAccountDetails(username);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
