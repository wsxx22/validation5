package com.example.validation5.repo;

import com.example.validation5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    boolean existsByPesel (String pesel);

}
