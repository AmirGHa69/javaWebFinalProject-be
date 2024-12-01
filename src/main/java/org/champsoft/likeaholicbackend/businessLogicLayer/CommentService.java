package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.Comment;
import org.champsoft.likeaholicbackend.presentationLayer.comments.CommentRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.comments.CommentResponseModel;

import java.util.List;

public interface CommentService {
//    Comment addComment(Comment comment);

    CommentResponseModel addComment(CommentRequestModel commentRequestModel);
    Comment updateComment(Long id, Comment comment);
    void deleteComment(Long id);
    List<Comment> getCommentsByPostId(Long postId);
    List<Comment> getAllComments();
}