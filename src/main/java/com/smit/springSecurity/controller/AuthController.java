package com.smit.springSecurity.controller;

import com.smit.springSecurity.entity.Users;
import com.smit.springSecurity.repository.UserRepository;
import com.smit.springSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


}
