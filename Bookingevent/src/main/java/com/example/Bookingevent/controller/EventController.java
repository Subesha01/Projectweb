package com.example.Bookingevent.controller;

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

import com.example.Bookingevent.model.Event;
import com.example.Bookingevent.service.EventService;
import java.util.*;

@RestController
@RequestMapping("/api")
public class EventController {
    private final EventService serv;

    public EventController(EventService serv) {
        this.serv = serv;
    }

    @GetMapping("/map")
    public ResponseEntity<List<Event>> getEventById() {
        List<Event> events = serv.getEventById();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @PostMapping("/map")
    public ResponseEntity<Event> addcustomer(@RequestBody Event pro) {
        Event customer = serv.addCustomer(pro);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping("/map/{id}")
    public ResponseEntity<Event> update(@PathVariable int id, @RequestBody Event client) {
        return new ResponseEntity<>(serv.update(id, client), HttpStatus.OK);
    }

    @DeleteMapping("/map/{signId}")
    public ResponseEntity<Void> delete(@PathVariable int signId) {
        serv.delete(signId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{signinName}")
    public ResponseEntity<List<Event>> sortTheRecords(@PathVariable String signinName) {
        List<Event> field = serv.sortTheRecords(signinName);
        return new ResponseEntity<>(field, HttpStatus.OK);
    }

    @GetMapping("/{offset}/{pagesize}")
    public ResponseEntity<List<Event>> getMethodName(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int size) {
        List<Event> list = serv.getPaginationSignin(offset, size);
        if (list.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Event>> getSortedPagination(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int size, @PathVariable("field") String field) {
        List<Event> list = serv.getSortedPaginationSignin(offset, size, field);
        if (list.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}