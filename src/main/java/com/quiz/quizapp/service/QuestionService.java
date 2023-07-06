package com.quiz.quizapp.service;

import com.quiz.quizapp.dao.QuestionDAO;
import com.quiz.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;
    public List<Question> getAllQuestions() {
        return questionDAO.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDAO.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDAO.save(question);
        return "Successfully saved the question";
    }

    public String deleteQuestion(int id) {
        questionDAO.deleteById(id);
        return "Successfully deleted the question";
    }
}
