package com.quiz.quizapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column
    private String category;

    @Column(name = "difficulty_level")
    private String difficultyLevel;

    @Column
    private String option1;

    @Column
    private String option2;

    @Column
    private String option3;

    @Column
    private String option4;

    @Column(name = "question_title")
    private String questionTitle;

    @Column(name = "right_answer")
    private String rightAnswer;
}
