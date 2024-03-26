package com.imitation.amity.repository.user;

import com.imitation.amity.domain.AmityUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    void save(AmityUser user);
    Optional<AmityUser> findByUsername(String username);
}
