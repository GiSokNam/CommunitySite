package com.imitation.amity.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Answer {
    private Long id;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private Question question;
}
