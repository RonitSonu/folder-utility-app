package com.rightdatajson.restapi.controller;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.rightdatajson.restapi.model.LevelOne;
import com.rightdatajson.restapi.repository.LevelOneRepository;
import com.rightdatajson.restapi.service.LevelOneService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lvl")
public class LevelOneController {

    @Autowired
    LevelOneService userService;



    @PostMapping(value = "/create")
    public ResponseEntity<LevelOne> createUser(@RequestBody LevelOne user) {
        LevelOne savedUser = userService.createUser(user);
        return new ResponseEntity<LevelOne>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<LevelOne> getUserById(@PathVariable("id") String userId){
        LevelOne user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LevelOne>> getAllUsers(){
        List<LevelOne> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);

    }



}
