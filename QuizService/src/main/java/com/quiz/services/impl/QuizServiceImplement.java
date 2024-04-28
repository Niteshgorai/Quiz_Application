package com.quiz.services.impl;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepositories;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImplement implements QuizService {

    private QuizRepositories quizRepositories;

    private QuestionClient questionClient;

    public QuizServiceImplement(QuestionClient questionClient, QuizRepositories quizRepositories) {
        this.questionClient = questionClient;
        this.quizRepositories = quizRepositories;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepositories.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepositories.findAll();
        List<Quiz> newQuizList =quizzes.stream().map(quiz ->{
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz=quizRepositories.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
