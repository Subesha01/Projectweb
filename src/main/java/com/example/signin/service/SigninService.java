package com.example.signin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import com.example.signin.model.Signin;
import com.example.signin.repository.SigninRepository;

@Service
public class SigninService {
    @Autowired
    public final SigninRepository signinRepository;// repository called

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

    public List<Signin> sortTheRecords(String clientName) {

        return signinRepository.findAll(Sort.by(Sort.Direction.DESC, clientName));
    }

    public List<Signin> getPaginationSignin(int offset, int size) {
        return signinRepository.findAll(PageRequest.of(offset, size)).getContent();
    }

    public List<Signin> getSortedPaginationSignin(int offset, int size, String field) {
        return signinRepository.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }
}
