package com.question.controller;

import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

//    public QuestionController(QuestionService questionService) {
//        this.questionService = questionService;
//    }

//    create
    @PostMapping
    public Question create(@RequestBody Question question){
        return questionService.create(question);
    }
    @GetMapping
    public List<Question> getAll(){
        return questionService.get();
    }
    @GetMapping("/{questionid}")
    public Question getOne(@PathVariable Long questionid){
        return questionService.getOne(questionid);
    }

//    Get All questions of specific quiz
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){
        return questionService.getQuestionsOfQuize(quizId);
    }
}

