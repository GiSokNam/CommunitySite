package com.imitation.amity.repository.question;

import com.imitation.amity.common.RequestList;
import com.imitation.amity.domain.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface QuestionMapper {
    List<Question> findAllByKeyword(RequestList<?> requestList, String kw);
    int totalPageCnt(Question question, String kw);
    void save(Question question);
}
