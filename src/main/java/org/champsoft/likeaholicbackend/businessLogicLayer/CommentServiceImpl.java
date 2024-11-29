package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.businessLogicLayer.CommentService;
import org.champsoft.likeaholicbackend.dataAccessLayer.Comment;
import org.champsoft.likeaholicbackend.dataAccessLayer.CommentRepository;
import org.champsoft.likeaholicbackend.dataAccessLayer.User;
import org.champsoft.likeaholicbackend.dataMapperLayer.CommentRequestMapper;
import org.champsoft.likeaholicbackend.dataMapperLayer.CommentResponseMapper;
import org.champsoft.likeaholicbackend.presentationLayer.comments.CommentRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.comments.CommentResponseModel;
import org.champsoft.likeaholicbackend.presentationLayer.users.UserResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Long id, Comment comment) {
        Comment existingComment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        existingComment.setContent(comment.getContent());
        return commentRepository.save(existingComment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}