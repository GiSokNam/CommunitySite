package com.imitation.amity.service;

import com.imitation.amity.controller.question.QuestionForm;
import com.imitation.amity.domain.Question;
import com.imitation.amity.repository.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public Page<Question> getList(int page, String kw) {

        Pageable pageable = PageRequest.of(page, 10);
        return questionRepository.findAllByKeyword(kw, pageable);
    }

    public void create(QuestionForm questionForm) {
        Question question = new Question();
        question.setSubject(questionForm.getSubject());
        question.setContent(questionForm.getContent());
        questionRepository.save(question);
    }
}
