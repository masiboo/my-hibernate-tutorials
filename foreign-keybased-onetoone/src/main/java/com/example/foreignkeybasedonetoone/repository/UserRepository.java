package com.example.foreignkeybasedonetoone.repository;

import com.example.foreignkeybasedonetoone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
