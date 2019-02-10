package com.example.danaa.exam_10feb.Model;

import java.io.Serializable;

public class Answer implements Serializable {
    private Integer questionId;
    private String answer;

    public Answer(Integer questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
