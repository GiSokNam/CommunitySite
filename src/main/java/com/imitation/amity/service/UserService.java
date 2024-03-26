package com.imitation.amity.service;

import com.imitation.amity.controller.user.UserCreateForm;
import com.imitation.amity.domain.AmityUser;
import com.imitation.amity.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public void create(UserCreateForm userCreateForm) {
        AmityUser user = new AmityUser();
        user.setUsername(userCreateForm.getUsername());
        user.setEmail(userCreateForm.getEmail());
        user.setPassword(passwordEncoder.encode(userCreateForm.getPassword1()));
        userRepository.save(user);
    }

    public AmityUser getUser(String username) {
        Optional<AmityUser> amityUser = userRepository.findByUsername(username);
        if (amityUser.isPresent()) {
            return amityUser.get();
        } else {
            throw new RuntimeException("amityuser not found");
        }
    }
}
