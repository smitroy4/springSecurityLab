package com.smit.springSecurity.controller;

import com.smit.springSecurity.dto.LoginDto;
import com.smit.springSecurity.dto.SignUpDto;
import com.smit.springSecurity.dto.UserDto;
import com.smit.springSecurity.entity.Users;
import com.smit.springSecurity.repository.UserRepository;
import com.smit.springSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto){
        UserDto userDto = userService.signUp(signUpDto);
        return ResponseEntity.ok(userDto);
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
//        String token = userService.login(loginDto);
//        return ResponseEntity.ok(token);
//    }


}
