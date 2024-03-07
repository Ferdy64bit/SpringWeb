package com.example.demo.BaseComponent.repository;

import com.example.demo.BaseComponent.implComponnentEntity.ImpLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImplLoginRepo extends JpaRepository<ImpLogin,String> {
}
