package org.example.domain;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> all() {
        return userRepository.findAll();
    }

    public User one(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find User for ID: " + id));
    }

    public User update(User request, Long id) {

        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(request.getUsername());
                    user.setFirstName(request.getFirstName());
                    user.setLastName(request.getLastName());
                    user.setEmail(request.getEmail());
                    user.setPhoneNumber(request.getPhoneNumber().toString());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("Could not find User for ID: " + id));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
