package com.imitation.amity.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
public class Question {
    private Long id;
    private String subject;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private List<Answer> answerList;
    private AmityUser author;
    Set<AmityUser> voter;
}
