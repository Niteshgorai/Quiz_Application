package com.quiz.repositories;

import com.quiz.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepositories extends JpaRepository<Quiz, Long> {

}
