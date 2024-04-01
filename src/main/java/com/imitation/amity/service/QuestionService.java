package com.imitation.amity.service;

import com.imitation.amity.common.RequestList;
import com.imitation.amity.controller.question.QuestionForm;
import com.imitation.amity.domain.AmityUser;
import com.imitation.amity.domain.Question;
import com.imitation.amity.repository.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public void create(QuestionForm questionForm, AmityUser amityUser) {
        Question question = new Question();
        question.setSubject(questionForm.getSubject());
        question.setContent(questionForm.getContent());
        question.setCreateDate(LocalDateTime.now());
        question.setAuthor(amityUser);
        questionRepository.save(question);
    }

    public Question getQuestion(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new RuntimeException("question not found");
        }
    }

    public void modify(Question question, QuestionForm questionForm) {
        question.setSubject(questionForm.getSubject());
        question.setContent(questionForm.getContent());
        question.setModifyDate(LocalDateTime.now());
        questionRepository.modify(question);
    }

    public void delete(Question question) {
        questionRepository.delete(question);
    }

    public void vote(Question question, AmityUser amityUser) {
        question.getVoter().add(amityUser);
        int cnt = questionRepository.voteCountCheck(question);
        if (cnt == 0) questionRepository.vote(question);
        else questionRepository.voteToCancel(question);
    }

    public List<Question> getMainQnaList(Question question) {
        return questionRepository.getMainQnaList(question);
    }
}
