package com.imitation.amity.repository.answer;

import com.imitation.amity.domain.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AnswerRepository {

    private final AnswerMapper answerMapper;
    public void save(Answer answer) {
        answerMapper.save(answer);
    }

    public Optional<Answer> findById(Long id) {
        return answerMapper.findById(id);
    }

    public void delete(Answer answer) {
        answerMapper.delete(answer);
    }

    public void modify(Answer answer) {
        answerMapper.modify(answer);
    }

    public void vote(Answer answer) {
        answerMapper.vote(answer);
    }
}
