package com.imitation.amity.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class Answer {
    private Long id;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private Question question;
    private AmityUser author;
    Set<AmityUser> voter;
}
