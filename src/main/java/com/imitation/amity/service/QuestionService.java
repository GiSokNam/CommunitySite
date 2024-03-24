package com.imitation.amity.service;

import com.imitation.amity.common.RequestList;
import com.imitation.amity.controller.question.QuestionForm;
import com.imitation.amity.domain.Question;
import com.imitation.amity.repository.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public Page<Question> getList(Question question, Pageable pageable, String kw) {
        RequestList<?> requestList = RequestList.builder()
                .data(question)
                .pageable(pageable)
                .build();

        List<Question> content = questionRepository.findAllByKeyword(requestList, kw);
        int totalPage = questionRepository.totalPageCnt(question, kw);
        return new PageImpl<>(content, pageable, totalPage);
    }

    public void create(QuestionForm questionForm) {
        Question question = new Question();
        question.setSubject(questionForm.getSubject());
        question.setContent(questionForm.getContent());
        question.setCreateDate(LocalDateTime.now());
        questionRepository.save(question);
    }
}
