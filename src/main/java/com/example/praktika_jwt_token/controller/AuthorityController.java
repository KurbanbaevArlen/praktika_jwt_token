package com.example.praktika_jwt_token.controller;

import com.example.praktika_jwt_token.dto.AuthorityResponse;
import com.example.praktika_jwt_token.dto.RegisterRequest;
import com.example.praktika_jwt_token.entity.User;
import com.example.praktika_jwt_token.security.JwtProvider;
import com.example.praktika_jwt_token.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
public class AuthorityController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider provider;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setPassword(request.getPassword());
        user.setLogin(request.getLogin());
        userService.saveUser(user);
        return "ok";
    }

    @PostMapping("/auth")
    public AuthorityResponse auth(@RequestBody RegisterRequest request) {
        System.out.println(1);
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        System.out.println(2);
        System.out.println(user);
        String token = provider.generaToken(user.getLogin());
        System.out.println(3);
        return new AuthorityResponse(token);
    }
}
