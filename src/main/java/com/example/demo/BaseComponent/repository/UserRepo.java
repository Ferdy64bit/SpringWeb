package com.example.demo.BaseComponent.repository;

import com.example.demo.BaseComponent.implComponnentEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
