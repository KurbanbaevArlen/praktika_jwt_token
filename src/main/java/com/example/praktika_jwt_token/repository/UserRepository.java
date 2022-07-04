package com.example.praktika_jwt_token.repository;

import com.example.praktika_jwt_token.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.ValidationException;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select o from User o where o.login = :login")
    Optional<User> getByEmail(String email);

    default User finByLogin(String login){
        Optional<User> optionalUser = getByEmail(login);
        if (optionalUser.isEmpty()){
            throw new ValidationException("not found by email : "+login);
        }
        return optionalUser.get();
    }
}
