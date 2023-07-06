package com.quiz.quizapp.service;

import com.quiz.quizapp.dao.QuestionDAO;
import com.quiz.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        }catch (Exception e){

        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_GATEWAY);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){

        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_GATEWAY);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDAO.save(question);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }catch (Exception e){

        }
        return new ResponseEntity<>("", HttpStatus.BAD_GATEWAY);
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        try {
            questionDAO.deleteById(id);
            return new ResponseEntity<>("Successfully deleted the question", HttpStatus.OK);
        }catch (Exception e){

        }
        return new ResponseEntity<>("", HttpStatus.BAD_GATEWAY);
    }
}
