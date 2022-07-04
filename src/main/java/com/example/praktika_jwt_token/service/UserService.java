package com.example.praktika_jwt_token.service;

import com.example.praktika_jwt_token.entity.Role;
import com.example.praktika_jwt_token.entity.User;
import com.example.praktika_jwt_token.repository.RoleRepository;
import com.example.praktika_jwt_token.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User saveUser(User user){
        Role role = new Role();
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User findByLogin(String login) {
        return userRepository.finByLogin(login);

    }

    public User findByLoginAndPassword(String login, String password) {
        User user = findByLogin(login);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            } else {
                throw new BadCredentialsException("invalid");
            }
        }
        throw new BadCredentialsException("invalid");
    }
}
