package com.quiz.quizapp.service;

import com.quiz.quizapp.dao.QuestionDAO;
import com.quiz.quizapp.dao.QuizDAO;
import com.quiz.quizapp.entity.Question;
import com.quiz.quizapp.entity.Quiz;
import com.quiz.quizapp.model.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<QuestionWrapper>> getQuizById(int id) {
        Optional<Quiz> quiz = quizDAO.findById(id);
        List<Question> questionList = quiz.get().getQuestions();
        List<QuestionWrapper> qw = new LinkedList<>();
        for(Question q : questionList){
            qw.add(new QuestionWrapper(q.getId(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestionTitle()));
        }
        return new ResponseEntity<>(qw,HttpStatus.OK);
    }
}
