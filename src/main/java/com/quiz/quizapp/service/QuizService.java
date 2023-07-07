package com.quiz.quizapp.service;

import com.quiz.quizapp.dao.QuestionDAO;
import com.quiz.quizapp.dao.QuizDAO;
import com.quiz.quizapp.entity.Question;
import com.quiz.quizapp.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDAO quizDAO;

    @Autowired
    QuestionDAO questionDAO;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDAO.findRandomQuestions(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        System.out.println(title);
        quiz.setQuestions(questions);
        quizDAO.save(quiz);

        return new ResponseEntity<>("Quiz saved", HttpStatus.CREATED);
    }
}
