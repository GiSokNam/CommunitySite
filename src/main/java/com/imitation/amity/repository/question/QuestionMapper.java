package com.imitation.amity.repository.question;

import com.imitation.amity.domain.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Mapper
public interface QuestionMapper {
    Page<Question> findAllByKeyword(String kw, Pageable pageable);

    void save(Question question);
}
