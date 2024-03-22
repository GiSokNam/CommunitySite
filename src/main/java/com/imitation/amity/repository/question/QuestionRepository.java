package com.imitation.amity.repository.question;

import com.imitation.amity.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {
    private final QuestionMapper questionMapper;

    public Page<Question> findAllByKeyword(String kw, Pageable pageable) {
        return questionMapper.findAllByKeyword(kw, pageable);
    }

    public void save(Question question) {
        questionMapper.save(question);
    }
}
