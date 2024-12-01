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
        User user = userRepository.findById(commentRequestModel.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + commentRequestModel.getUserId()));

        // Fetch the Post entity
        Post post = postRepository.findById(commentRequestModel.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found with ID: " + commentRequestModel.getPostId()));

        // Map the CommentRequestModel to a Comment entity
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setContent(commentRequestModel.getContent());

        // Generate a unique commentId
        comment.setCommentId(System.currentTimeMillis()); // Use current time for uniqueness

        // Save the Comment entity
        commentRepository.save(comment);

        // Map the saved Comment entity to a CommentResponseModel and return it
        return commentResponseMapper.entityToResponseModel(comment);
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