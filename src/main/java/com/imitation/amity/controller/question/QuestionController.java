package com.imitation.amity.controller.question;

import com.imitation.amity.domain.Question;
import com.imitation.amity.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model,
                       @ModelAttribute Question question,
                       @PageableDefault(size = 10) Pageable pageable,
                       @RequestParam(value = "kw", defaultValue = "") String kw) {

        Page<Question> paging = questionService.getList(question, pageable, kw);
        model.addAttribute("paging", paging);
        model.addAttribute("kw", kw);
        return "question/list";
    }

    @GetMapping("/new")
    public String create(QuestionForm questionForm) {
        return "question/new";
    }

    @PostMapping("/new")
    public String create(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question/new";
        }
        questionService.create(questionForm);
        return "redirect:/question/list";
    }

    @GetMapping("/detail")
    public String detail() {
        return "question/detail";
    }
}
