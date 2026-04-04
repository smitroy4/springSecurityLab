package com.smit.springSecurity.service.impl;

import com.smit.springSecurity.dto.UserDTO;
import com.smit.springSecurity.entity.User;
import com.smit.springSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
//public class UserServiceImpl implements UserDetailsService {
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
//    }


    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

}


// NOTE: The above code is a partial implementation of the UserServiceImpl class. The loadUserByUsername method is currently returning null, which is not the expected behavior. You would need to implement this method to fetch the user details from the database using the UserRepository and return a UserDetails object. Additionally, you can implement the other methods for creating, retrieving, and deleting users as needed.


//
//
//public void deleteUser(Long id) {
//    userRepository.deleteById(id);
// }