package com.imitation.amity.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Question {
    private Long id;
    private String subject;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifyDate;
    private List<Answer> answerList;
    private AmityUser author;
}
