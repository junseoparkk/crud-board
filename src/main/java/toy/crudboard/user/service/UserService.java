package toy.crudboard.user.service;

import toy.crudboard.user.entity.User;

public interface UserService {
    User signup(String name, String email, String password);
}
