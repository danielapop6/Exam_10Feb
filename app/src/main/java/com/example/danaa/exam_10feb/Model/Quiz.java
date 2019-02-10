package com.example.danaa.exam_10feb.Model;

import java.util.HashMap;

public class Quiz {

    private HashMap<Integer, String> answers;

    public Quiz() {
        this.answers = new HashMap<>();
    }

    public HashMap<Integer, String> getAnswers() {
        return answers;
    }

    public void setAnswers(HashMap<Integer, String> answers) {
        this.answers = answers;
    }

    public void add(Integer id, String answer) {
        answers.put(id, answer);
    }
}
