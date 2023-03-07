package ir.asran.loginpage.service;

import ir.asran.loginpage.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User findByUsername(String username);

    List<User> findAllUsers();
}
