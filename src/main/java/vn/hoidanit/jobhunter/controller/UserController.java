package vn.hoidanit.jobhunter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User createNewUser(@RequestBody User postmanUser) {
        User Thuan = this.userService.handleCreateUser(postmanUser);
        return Thuan;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable long id) {
        this.userService.handleDeleteUser(id);
        return "ID: ";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        return this.userService.fetchUserById(id);
    }

    @GetMapping("/user")
    public List<User> getAllUser() {
        return this.userService.fetchAllUser();
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User postmanUser) {
        return this.userService.handleUpdateUser(postmanUser);
    }
}
