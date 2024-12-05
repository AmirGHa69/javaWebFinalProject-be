package org.champsoft.likeaholicbackend.businessLogicLayer;

import jakarta.transaction.Transactional;
import org.champsoft.likeaholicbackend.dataAccessLayer.*;
import org.champsoft.likeaholicbackend.dataMapperLayer.CommentResponseMapper;
import org.champsoft.likeaholicbackend.presentationLayer.comments.CommentRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.comments.CommentResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentResponseMapper commentResponseMapper;

    @Override
    public CommentResponseModel addComment(CommentRequestModel commentRequestModel) {
        User user = userRepository.findByUserId(commentRequestModel.getUserId());
        Post post = postRepository.findByPostId(commentRequestModel.getPostId());
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setContent(commentRequestModel.getContent());

        comment.setCommentId(String.valueOf(System.currentTimeMillis())); // Use current time for uniqueness

        commentRepository.save(comment);

        return commentResponseMapper.entityToResponseModel(comment);
    }



    @Override
    public Comment updateComment(String commentId, Comment comment) {
        Comment existingComment = commentRepository.findByCommentId(commentId);
        existingComment.setContent(comment.getContent());
        return commentRepository.save(existingComment);
    }

    @Override
    @Transactional
    public void deleteComment(String commentId) {
        Comment comment = commentRepository.findByCommentId(commentId);
        commentRepository.delete(comment);
    }

    @Override
    public List<Comment> getCommentsByPostId(String postId) {
        return commentRepository.findByPost_PostId(postId);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}