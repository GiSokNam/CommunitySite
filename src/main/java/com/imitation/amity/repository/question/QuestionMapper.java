package com.imitation.amity.repository.question;

import com.imitation.amity.common.RequestList;
import com.imitation.amity.domain.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QuestionMapper {
    List<Question> findAllByKeyword(RequestList<?> requestList, String kw);
    int totalPageCnt(Question question, String kw);
    void save(Question question);

    Optional<Question> findById(Long id);

    void modify(Question question);

    void delete(Question question);

    void vote(Question question);
}
