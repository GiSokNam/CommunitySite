package com.imitation.amity.repository.answer;

import com.imitation.amity.domain.Answer;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AnswerMapper {
    void save(Answer answer);

    Optional<Answer> findById(Long id);

    void delete(Answer answer);

    void modify(Answer answer);

    void vote(Answer answer);
}
