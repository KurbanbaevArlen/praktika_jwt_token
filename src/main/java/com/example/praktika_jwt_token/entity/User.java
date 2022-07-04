package com.example.praktika_jwt_token.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String login;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
