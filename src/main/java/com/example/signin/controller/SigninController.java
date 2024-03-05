package com.example.signin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.signin.model.Signin;
import com.example.signin.service.SigninService;

@RestController
@RequestMapping("/api")
public class SigninController {

    @Autowired
    private final SigninService signinService;

    public SigninController(SigninService signinService) {
        this.signinService = signinService;
    }

    @PostMapping("/signin")
    public ResponseEntity<Signin> createSignin(@RequestBody Signin client) {
        Signin createSignin = signinService.createSignin(client);
        return new ResponseEntity<>(createSignin, HttpStatus.CREATED);
    }

    public static final Logger logger = LoggerFactory.getLogger(SigninController.class);

    @RequestMapping("/logger")
    public String message() {
        logger.info("INFO Enabled");
        logger.error("Error Enabled");
        logger.debug("Debug Enabled");
        logger.trace("trace enabled");
        logger.warn("warn enabled");
        return "Test Logging";
    }

    @GetMapping("/signin")
    public ResponseEntity<List<Signin>> getAllSignin() {
        List<Signin> client = signinService.getAllSignin();
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("/{signinName}")
    public ResponseEntity<List<Signin>> sortTheRecords(@PathVariable String signinName) {
        List<Signin> field = signinService.sortTheRecords(signinName);
        return new ResponseEntity<>(field, HttpStatus.OK);
    }

    @GetMapping("/signin/{signinId}")
    public ResponseEntity<Signin> getById(@PathVariable int signinId) {
        Signin client = signinService.getSigninId(signinId);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/signin/{id}")
    public ResponseEntity<Signin> update(@PathVariable int id, @RequestBody Signin client) {
        return new ResponseEntity<>(signinService.update(id, client), HttpStatus.OK);
    }

    @DeleteMapping("/signin/{signId}")
    public ResponseEntity<Void> delete(@PathVariable int signId) {
        signinService.delete(signId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{offset}/{pagesize}")
    public ResponseEntity<List<Signin>> getMethodName(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int size) {
        List<Signin> list = signinService.getPaginationSignin(offset, size);
        if (list.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Signin>> getSortedPagination(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int size, @PathVariable("field") String field) {
        List<Signin> list = signinService.getSortedPaginationSignin(offset, size, field);
        if (list.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}