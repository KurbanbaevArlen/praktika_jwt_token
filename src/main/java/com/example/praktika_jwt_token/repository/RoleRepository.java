package com.example.praktika_jwt_token.repository;

import com.example.praktika_jwt_token.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
