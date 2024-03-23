package com.rightdatajson.restapi.service;

import com.rightdatajson.restapi.model.LevelOne;

import java.util.List;

public interface LevelOneService {

    LevelOne createUser(LevelOne user);

    LevelOne getUserById(String userId);

    List<LevelOne> getAllUsers();


    void deleteUser(String userId);
}
