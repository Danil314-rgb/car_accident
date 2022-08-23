package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.User;
import ru.job4j.accident.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public User findByEmailAndPsw(String email, String psw) {
        return userRepository.findByEmailAndPassword(email, psw);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
