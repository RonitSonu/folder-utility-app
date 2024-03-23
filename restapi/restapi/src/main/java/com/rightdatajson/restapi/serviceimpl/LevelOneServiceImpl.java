package com.rightdatajson.restapi.serviceimpl;

import com.rightdatajson.restapi.model.LevelOne;
import com.rightdatajson.restapi.repository.LevelOneRepository;
import com.rightdatajson.restapi.service.LevelOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelOneServiceImpl implements LevelOneService {


    @Autowired
    LevelOneRepository userRepository;

    @Override
    public LevelOne createUser(LevelOne user) {
        if(user.getId() != null){
            LevelOne parentId = userRepository.findById(user.getId()).orElse(null);
            if(parentId != null){
                parentId.getChildFolders().add(user);
                userRepository.save(parentId);

            }
        }
        return userRepository.save(user);
    }

    @Override
    public LevelOne getUserById(String userId) {
        Optional<LevelOne> optionalUser =userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<LevelOne> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String userId) {
        LevelOne userToDelete = userRepository.findById(userId).orElse(null);
        if(userToDelete != null){
            deleteUserRecursively(userToDelete);
        }
        //userRepository.deleteById(userId);

    }

    private void deleteUserRecursively(LevelOne user) {
        List<LevelOne> childFolders = user.getChildFolders();
        for (LevelOne childFolder : childFolders) {
            deleteUserRecursively(childFolder);
        }
        userRepository.deleteById(user.getId());
    }
}
