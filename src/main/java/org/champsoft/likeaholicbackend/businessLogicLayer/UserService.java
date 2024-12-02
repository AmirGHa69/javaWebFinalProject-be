package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
