package com.example.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Topic implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;
    private String id;
    private String title;
    private String name;
    private String content;
    private String time;
}
