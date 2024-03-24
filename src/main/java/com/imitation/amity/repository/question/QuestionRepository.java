package com.imitation.amity.repository.question;

import com.imitation.amity.common.RequestList;
import com.imitation.amity.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {
    private final QuestionMapper questionMapper;

    public List<Question> findAllByKeyword(RequestList<?> requestList, String kw) {
        return questionMapper.findAllByKeyword(requestList, kw);
    }

    public int totalPageCnt(Question question, String kw) {
        return questionMapper.totalPageCnt(question,kw);
    }

    public void save(Question question) {
        questionMapper.save(question);
    }
}
