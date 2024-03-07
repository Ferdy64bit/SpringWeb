package com.example.demo.BaseComponent.repository;

import com.example.demo.BaseComponent.implComponnentEntity.ImplRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepo extends JpaRepository<ImplRegister,String> {
}
