package com.cognizant.jwthandson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public String authenticate(@RequestParam String username, @RequestParam String password) {
        // Dummy authentication check
        if ("user".equals(username) && "pass".equals(password)) {
            return jwtUtil.generateToken(username);
        }
        return "Invalid Credentials";
    }
}
