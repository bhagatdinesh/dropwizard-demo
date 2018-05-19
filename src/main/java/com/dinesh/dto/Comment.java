package com.dinesh.dto;

import java.util.Date;

import lombok.Data;


@Data
public class Comment {
    private String sessionId;
    private String productId;
    private String comment;
    private Date date = new Date();
}
