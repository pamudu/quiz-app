package com.quiz.quizapp.controller;

import com.quiz.quizapp.entity.Question;
import com.quiz.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public List<Question> allQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("/category/{category}")
    public List<Question> questionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){
        System.out.println("hi");
        return questionService.addQuestion(question);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable int id){
        return questionService.deleteQuestion(id);
    }
}
