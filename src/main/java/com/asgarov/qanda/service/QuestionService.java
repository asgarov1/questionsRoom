package com.asgarov.qanda.service;

import com.asgarov.qanda.domain.Question;
import com.asgarov.qanda.domain.Room;
import com.asgarov.qanda.persistence.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository repository;

    public Question createQuestion(String questionText, Room room) {
        Question question = new Question(questionText, LocalDateTime.now(), room);
        repository.save(question);
        return question;
    }

    public Question findById(Long questionId) {
        return repository.findById(questionId).orElseThrow();
    }

    public void update(Question question) {
        repository.save(question);
    }
}
