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

    public User updateUser(String userId, User updatedUser) {
        User existingUser = userRepository.findByUserId(userId);
        existingUser.setUserName(updatedUser.getUserName());
        existingUser.setUserEmail(updatedUser.getUserEmail());

        // Preserve the existing password if the updated password is null or empty
        if (updatedUser.getUserPassword() != null && !updatedUser.getUserPassword().isEmpty()) {
            existingUser.setUserPassword(updatedUser.getUserPassword());
        }

        return userRepository.save(existingUser);
    }


    @Override
    public void deleteUser(String userId) {
        userRepository.deleteByUserId(userId);
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findByUserId(userId);
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
