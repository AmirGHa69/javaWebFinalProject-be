package org.champsoft.likeaholicbackend.businessLogicLayer;

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

    @Autowired private PostRepository postRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private CommentResponseMapper commentResponseMapper;

    @Override
    public CommentResponseModel addComment(CommentRequestModel commentRequestModel) {
        // Fetch the User entity
        User user = userRepository.findByUserId(commentRequestModel.getUserId());
        // Fetch the Post entity
        Post post = postRepository.findByPostId(commentRequestModel.getPostId());
        // Map the CommentRequestModel to a Comment entity
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setContent(commentRequestModel.getContent());

        // Generate a unique commentId
        comment.setCommentId(String.valueOf(System.currentTimeMillis())); // Use current time for uniqueness

        // Save the Comment entity
        commentRepository.save(comment);

        // Map the saved Comment entity to a CommentResponseModel and return it
        return commentResponseMapper.entityToResponseModel(comment);
    }



    @Override
    public Comment updateComment(String commentId, Comment comment) {
        Comment existingComment = commentRepository.findByCommentId(commentId);
        existingComment.setContent(comment.getContent());
        return commentRepository.save(existingComment);
    }

    @Override
    public void deleteComment(String commentId) {
        commentRepository.deleteByCommentId(commentId);
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