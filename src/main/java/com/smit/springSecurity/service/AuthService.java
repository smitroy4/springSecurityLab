package com.smit.springSecurity.service;

import com.smit.springSecurity.dto.LoginDto;
import com.smit.springSecurity.entity.Users;
import com.smit.springSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken((loginDto.getEmail()), loginDto.getPassword()));

        Users users = (Users) authentication.getPrincipal();
        String token = jwtService.generateToken(users);
        return token;
    }

}
