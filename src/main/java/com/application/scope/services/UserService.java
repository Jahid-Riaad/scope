package com.application.scope.services;

import com.application.scope.Interfaces.IUserService;
import com.application.scope.models.User;
import org.springframework.stereotype.Service;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Service
public class UserService implements IUserService {

    //creating object of ArrayList of user
    List<User> users = new ArrayList<User>();

    static User user1 = new User(1, "Rahad");
    static User user2 = new User(2, "Fahad");
    static User user3 = new User(3, "Sofik");
    static User user4 = new User(4, "Salam");
    static User user5 = new User(5, "Jamal");

    @Override
    public User addUser(User userDetails) {
        users.add(new User(userDetails.getUserId(), userDetails.getUserName()));
        return userDetails;

    }

    //adding users to the List
    @Override
    public List<User> create() {
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        ////returning a list of User
        return users;
    }

    @Override
    public User updateUser(String name, User userDetails) {
        User user = getUser(name);
        user.setUserId(userDetails.getUserId());
        user.setUserName(userDetails.getUserName());
        return user;
    }

    @Override
    public User getUser(String name) {
        User ruser = users.stream()
                .filter(user -> name.equals(user.getUserName()))
                .findAny()
                .orElse(null);
        return ruser;

    }

    @Override
    public void deleteUser(User user) {
        users.remove(users.indexOf(user));
    }


    @Override
    public List<User> getUserList() {
        if (users == null) {
            users = new ArrayList<>();
        }
        return users;

    }

    @Override
    public void setUserList(List<User> userList) {
        this.users = (ArrayList<User>) userList;
    }
}
