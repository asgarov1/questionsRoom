package com.asgarov.qanda.controller;

import com.asgarov.qanda.domain.Question;
import com.asgarov.qanda.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

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

    @PostMapping("/delete/{questionId}")
    public String deleteQuestion(@PathVariable Long questionId, HttpSession session) {
        Question question = questionService.findById(questionId);

        if(question.getSessionId().equals(session.getId())) {
            questionService.delete(question);
        }

        return "redirect:/room/" + question.getRoom().getName();
    }
}
