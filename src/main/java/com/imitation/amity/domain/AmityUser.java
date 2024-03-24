package com.imitation.amity.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AmityUser {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String realName;
    private String nickname;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
