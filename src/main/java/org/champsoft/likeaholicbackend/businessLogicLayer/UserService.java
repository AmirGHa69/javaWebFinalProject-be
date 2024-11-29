package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.User;
import org.champsoft.likeaholicbackend.presentationLayer.users.UserRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.users.UserResponseModel;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
