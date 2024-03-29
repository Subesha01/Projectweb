package com.example.signin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.signin.model.Signin;

@Repository
public interface SigninRepository extends JpaRepository<Signin, Integer> {

}