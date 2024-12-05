package org.champsoft.likeaholicbackend.presentationLayer.users;

import org.champsoft.likeaholicbackend.businessLogicLayer.UserService;
import org.champsoft.likeaholicbackend.dataAccessLayer.User;
import org.champsoft.likeaholicbackend.presentationLayer.users.UserRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.users.UserResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody UserRequestModel userRequestModel) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userRequestModel.getUserName());
        user.setUserEmail(userRequestModel.getUserEmail());
        user.setUserPassword(userRequestModel.getUserPassword()); // Include password

        return userService.updateUser(userId, user);
    }


    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}