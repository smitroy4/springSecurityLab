package com.smit.springSecurity.service;

import com.smit.springSecurity.dto.LoginDto;
import com.smit.springSecurity.dto.SignUpDto;
import com.smit.springSecurity.dto.UserDto;
import com.smit.springSecurity.entity.Users;
import com.smit.springSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User with email " + username + " not found."));
    }

    public UserDto signUp(SignUpDto signUpDto) {
        Optional<Users> user = userRepository.findByEmail(signUpDto.getEmail());
        if(user.isPresent()){
            throw new BadCredentialsException("User with email already exists" + signUpDto.getEmail());
        }
        Users toBeCreatedUser = modelMapper.map(signUpDto, Users.class);
        toBeCreatedUser.setPassword(passwordEncoder.encode(toBeCreatedUser.getPassword()));
        Users savedUser = userRepository.save(toBeCreatedUser);
        return modelMapper.map(savedUser, UserDto.class);
    }




}
