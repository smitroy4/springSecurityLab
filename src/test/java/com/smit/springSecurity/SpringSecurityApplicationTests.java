package com.smit.springSecurity;

import com.smit.springSecurity.entity.Users;
import com.smit.springSecurity.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityApplicationTests {


    @Autowired
    private JwtService jwtService;

	@Test
	void contextLoads() {

        Users user = new Users(4L, "smitroy", "smit@smail.com", "1234");

        String token = jwtService.generateToken(user);

        System.out.println(token);

        Long id = jwtService.getUserIdFromToken(token);

        System.out.println(id);

	}

}
