package com.dinesh.resources;

import com.google.common.base.Strings;

import com.dinesh.dto.Comment;
import com.dinesh.dto.CommentDetails;
import com.dinesh.dto.CommentResp;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by dinesh.bhagat on 19/05/18.
 */

@Path("/comment")
public class ProductComment {

    private static Set<String> set = new HashSet<>();

    static {
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("bad");
    }

    private static Map<String, List<CommentDetails>> comments = new HashMap<>();

    @POST
    @Produces(APPLICATION_JSON + ";charset=utf-8")
    @Consumes(APPLICATION_JSON + ";charset=utf-8")
    @Path("/add")
    public Response postComments(Comment comment) {
        String commentStr = StringUtils.chomp(comment.getComment());
        String[] str = commentStr.split(" +");
        CommentResp commentResp = new CommentResp();
        for (int i = 0; i < str.length; i++) {
            if (set.contains(str[i])) {
                commentResp.setMessage("Keep web clean!");
                commentResp.setStatusCode(HttpStatus.EXPECTATION_FAILED_417);
                return Response.ok(commentResp).build();
            }
        }
        Comment comment1 = new Comment();
        comment1.setComment(commentStr);
        comment1.setProductId(comment.getProductId());
        comment1.setSessionId(UUID.randomUUID().toString());
        String userId = UUID.randomUUID().toString();
        List<CommentDetails> commentDetailsLists = comments.get(userId);

        if (commentDetailsLists == null) {
            commentDetailsLists = new ArrayList<>();
            comments.put(userId, commentDetailsLists);
        }
        commentDetailsLists.add(new CommentDetails(comment1));

        return Response.ok().build();
    }

    @POST
    @Produces(APPLICATION_JSON + ";charset=utf-8")
    @Consumes(APPLICATION_JSON + ";charset=utf-8")
    @Path("/add/{userId}")
    public Response postCommentForUser(@PathParam(value = "userId") String userId, Comment comment) {
        String commentStr = StringUtils.chomp(comment.getComment());
        String[] str = commentStr.split(" +");
        CommentResp commentResp = new CommentResp();
        for (int i = 0; i < str.length; i++) {
            if (set.contains(str[i])) {
                commentResp.setMessage("Keep web clean!");
                commentResp.setStatusCode(HttpStatus.EXPECTATION_FAILED_417);
                return Response.ok(commentResp).build();
            }
        }
        Comment comment1 = new Comment();
        comment1.setComment(commentStr);
        comment1.setProductId(comment.getProductId());
        comment1.setSessionId(UUID.randomUUID().toString());
        List<CommentDetails> commentDetailsLists = comments.get(userId);

        if (commentDetailsLists == null) {
            commentDetailsLists = new ArrayList<>();
            comments.put(userId, commentDetailsLists);
        }
        commentDetailsLists.add(new CommentDetails(comment1));

        return Response.ok().build();
    }

    @GET
    @Produces(APPLICATION_JSON + ";charset=utf-8")
    @Path("/get")
    public Response getComments(Comment comment) {
        return Response.ok(comments).build();
    }

    @GET
    @Produces(APPLICATION_JSON + ";charset=utf-8")
    @Path("/user/{userId}")
    public Response getCommentsForUser(@PathParam(value = "userId") String userId) {
        if (Strings.isNullOrEmpty(userId)) {
            Response.ok().build();
        }
        return Response.ok(comments.get(userId)).build();
    }
}
