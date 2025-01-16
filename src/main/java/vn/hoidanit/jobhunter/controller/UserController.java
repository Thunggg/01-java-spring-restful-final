package vn.hoidanit.jobhunter.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;
import vn.hoidanit.jobhunter.service.error.IdInvalidException;

@RestController
public class UserController {
    private final UserService userService;
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@RequestBody User postmanUser) {
        String hashPassword = this.passwordEncoder.encode(postmanUser.getPassword());
        postmanUser.setPassword(hashPassword);
        User Thuan = this.userService.handleCreateUser(postmanUser);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Thuan);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) throws IdInvalidException {
        System.out.println(id);
        if (id > 1500) {
            throw new IdInvalidException("ID khong lon hon 1500");
        }
        this.userService.handleDeleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("Thuan");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User fetchUser = this.userService.fetchUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(fetchUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.fetchAllUser());
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User postmanUser) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.handleUpdateUser(postmanUser));
    }
}
