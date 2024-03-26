package com.imitation.amity.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AmityUser {
    private Long id;
    private String username;
    private String password;
    private String email;
}
