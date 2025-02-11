package vn.hoidanit.jobhunter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user) {
        return this.userRepository.save(user);
    }

    public void handleDeleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public User fetchUserById(long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    public List<User> fetchAllUser() {
        return this.userRepository.findAll();
    }

    public User handleUpdateUser(User user) {
        User curUser = this.fetchUserById(user.getId());
        if (curUser != null) {
            curUser.setName(user.getName());
            curUser.setEmail(user.getEmail());
            curUser.setPassword(user.getPassword());

            curUser = this.userRepository.save(curUser);
        }
        return curUser;
    }

    public User handleGetUserByUserName(String userName) {
        return this.userRepository.findByEmail(userName);
    }

}