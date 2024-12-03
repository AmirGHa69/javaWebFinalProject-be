package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(String userId, User user);
    void deleteUser(String userId);
    User getUserById(String userId);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
