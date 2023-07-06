package com.quiz.quizapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question")
public class QuestionController {

    @GetMapping("/allQuestions")
    public String allQuestions(){
        return "These are the questions .....";
    }
}
