package com.dinesh.dto;

import lombok.Data;

/**
 * Created by dinesh.bhagat on 19/05/18.
 */
@Data
public class CommentResp {
    private String message;
    private int statusCode;
    private CommentDetails commentDetails;
}
