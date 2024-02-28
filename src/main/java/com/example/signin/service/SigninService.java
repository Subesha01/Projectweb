package com.example.signin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.signin.model.Signin;
import com.example.signin.repository.SigninRepository;

@Service
public class SigninService {
    @Autowired
    private final SigninRepository signinRepository;// repository called

    public SigninService(SigninRepository signinRepository) {
        this.signinRepository = signinRepository;
    }

    public Signin createSignin(Signin client) {
        return signinRepository.save(client);
    }

    public List<Signin> getAllSignin() {
        return signinRepository.findAll();
    }

    public Signin getSigninId(int clientId) {
        return signinRepository.findById(clientId).orElse(null);
    }

    public Signin update(int id, Signin client) {
        Signin pros = signinRepository.findById(id).orElse(null);
        if (pros != null) {
            pros.setNo(client.getNo());
            pros.setUsername(client.getUsername());
            pros.setPassword(client.getPassword());
            return signinRepository.save(pros);
        }
        return client;
    }

    public void delete(int clientId) {
        signinRepository.deleteById(clientId);

    }
}