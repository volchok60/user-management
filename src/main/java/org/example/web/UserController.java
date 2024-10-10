package org.example.web;

import jakarta.validation.Valid;
import org.example.domain.User;
import org.example.domain.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody @Valid User request) {
        return userService.save(request);
    }

    @GetMapping
    public Iterable<User> all() {
        return userService.all();
    }

    @GetMapping("/{id}")
    User one(@PathVariable Long id) {
        return userService.one(id);
    }

    @PutMapping("/{id}")
    User update(@RequestBody @Valid User request, @PathVariable Long id) {
        return userService.update(request, id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
