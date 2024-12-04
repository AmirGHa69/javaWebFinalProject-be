package org.champsoft.likeaholicbackend.presentationLayer.comments;

import org.champsoft.likeaholicbackend.businessLogicLayer.CommentService;
import org.champsoft.likeaholicbackend.dataAccessLayer.Comment;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public CommentResponseModel addComment(@RequestBody CommentRequestModel commentRequestModel) {
        return commentService.addComment(commentRequestModel);
    }

    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable String commentId, @RequestBody Comment comment) {
        return commentService.updateComment(commentId, comment);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable String commentId) {
        commentService.deleteComment(commentId);
    }

    @GetMapping("/post/{postId}")
    public List<Comment> getCommentsByPostId(@PathVariable String postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }
}