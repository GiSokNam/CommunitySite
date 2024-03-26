package com.imitation.amity.repository.user;

import com.imitation.amity.domain.AmityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final UserMapper userMapper;
    public void save(AmityUser user) {
        userMapper.save(user);
    }


    public Optional<AmityUser> findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
