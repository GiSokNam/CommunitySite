package com.imitation.amity.controller;

import com.imitation.amity.domain.Question;
import com.imitation.amity.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final QuestionService questionService;

    @GetMapping("/")
    public String home(Model model, @ModelAttribute Question question) {
        List<Question> questionList = questionService.getMainQnaList(question);
        model.addAttribute("questionList", questionList);

        return "main";
    }


}
