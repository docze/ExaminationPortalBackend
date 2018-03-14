package pl.woonkievitch.Authentication.service;

import pl.woonkievitch.Authentication.entity.User;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
}
