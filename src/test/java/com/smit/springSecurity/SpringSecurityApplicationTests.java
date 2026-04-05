package com.smit.springSecurity;

import com.smit.springSecurity.entity.User;
import com.smit.springSecurity.service.impl.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityApplicationTests {


    @Autowired
    private JwtService jwtService;

	@Test
	void contextLoads() {

        User user = new User(4L, "smit@email.com", "smit@1234");

        String token = jwtService.generateToken(user);

        System.out.println("Generated Token: " + token);

        Long idFromToken = jwtService.getUserIdFromToken(token);

        System.out.println("User ID from Token: " + idFromToken);

	}

}
