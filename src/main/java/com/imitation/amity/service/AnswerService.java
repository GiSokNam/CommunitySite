package com.imitation.amity.service;

import com.imitation.amity.controller.answer.AnswerForm;
import com.imitation.amity.domain.AmityUser;
import com.imitation.amity.domain.Answer;
import com.imitation.amity.domain.Question;
import com.imitation.amity.repository.answer.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Answer create(Question question, AnswerForm answerForm, AmityUser amityUser) {
        Answer answer = new Answer();
        answer.setContent(answerForm.getContent());
        answer.setQuestion(question);
        answer.setAuthor(amityUser);
        answer.setCreateDate(LocalDateTime.now());
        answerRepository.save(answer);
        return answer;
    }

    public Answer getAnswer(Long id) {
        Optional<Answer> answer = answerRepository.findById(id);
        if (answer.isPresent()) {
            return answer.get();
        } else {
            throw new RuntimeException("answer not found");
        }
    }

    public void modify(Answer answer, AnswerForm answerForm) {
        answer.setContent(answerForm.getContent());
        answer.setModifyDate(LocalDateTime.now());
        answerRepository.modify(answer);
    }

    public void delete(Answer answer) {
        answerRepository.delete(answer);
    }

    public void vote(Answer answer, AmityUser amityUser) {
        answer.getVoter().add(amityUser);
        int cnt = answerRepository.voteCountCheck(answer);
        if(cnt == 0) answerRepository.vote(answer);
        else answerRepository.voteToCancel(answer);
    }
}
