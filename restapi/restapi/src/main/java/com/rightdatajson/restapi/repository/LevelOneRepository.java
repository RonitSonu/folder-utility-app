package com.rightdatajson.restapi.repository;

import com.rightdatajson.restapi.model.LevelOne;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface LevelOneRepository extends MongoRepository<LevelOne, String> {
}
