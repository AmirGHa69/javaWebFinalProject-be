package org.champsoft.likeaholicbackend.businessLogicLayer;

import jakarta.transaction.Transactional;
import org.champsoft.likeaholicbackend.dataAccessLayer.User;
import org.champsoft.likeaholicbackend.dataAccessLayer.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String id, User user) {
        User existingUser = userRepository.findByUserId(id);
        existingUser.setUserName(user.getUserName());
        existingUser.setUserEmail(user.getUserEmail());
        existingUser.setUserPassword(user.getUserPassword());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteByUserId(id);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findByUserId(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByUserId(email);
    }

//    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
