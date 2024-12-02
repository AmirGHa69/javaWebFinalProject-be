package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(String id, User user);
    void deleteUser(String id);
    User getUserById(String id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
