package com.application.scope.Interfaces;

import com.application.scope.models.User;

import java.util.List;

public interface IUserService {
    List<User> create();
    User addUser(User userDetails);
    User updateUser(String name, User userDetails);
    User getUser(String name);
    void deleteUser(User user);
    List<User> getUserList();
    void setUserList(List<User> userList);
}
