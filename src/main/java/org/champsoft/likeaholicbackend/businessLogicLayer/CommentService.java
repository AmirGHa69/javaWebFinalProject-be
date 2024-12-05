package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.Comment;
import org.champsoft.likeaholicbackend.presentationLayer.comments.CommentRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.comments.CommentResponseModel;

import java.util.List;

public interface CommentService {
    CommentResponseModel addComment(CommentRequestModel commentRequestModel);
    Comment updateComment(String commentId, Comment comment);
    void deleteComment(String commentId);
    List<Comment> getCommentsByPostId(String postId);
    List<Comment> getAllComments();
}