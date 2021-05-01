package com.asgarov.qanda.controller;

import com.asgarov.qanda.domain.Question;
import com.asgarov.qanda.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/{questionId}")
    public String updateQuestion(@PathVariable Long questionId, @RequestParam String questionText) {
        Question question = questionService.findById(questionId);
        question.setQuestionText(questionText);
        questionService.update(question);

        return "redirect:/room/" + question.getRoom().getName();
    }
}
