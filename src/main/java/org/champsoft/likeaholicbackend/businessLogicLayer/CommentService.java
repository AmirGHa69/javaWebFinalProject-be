package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.Comment;
import org.champsoft.likeaholicbackend.presentationLayer.comments.CommentRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.comments.CommentResponseModel;

import java.util.List;

public interface CommentService {
//    Comment addComment(Comment comment);

    CommentResponseModel addComment(CommentRequestModel commentRequestModel);
    Comment updateComment(String id, Comment comment);
    void deleteComment(String id);
    List<Comment> getCommentsByPostId(String postId);
    List<Comment> getAllComments();
}