package ir.asran.loginpage.service;

import ir.asran.loginpage.dto.UserDto;
import ir.asran.loginpage.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
