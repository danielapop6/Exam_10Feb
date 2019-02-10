package com.example.danaa.exam_10feb.Model;

import java.io.Serializable;

public class Question implements Serializable {
    private Integer id;
    private String text;

    public Question(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
