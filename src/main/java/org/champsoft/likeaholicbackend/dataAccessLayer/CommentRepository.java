package org.champsoft.likeaholicbackend.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost_PostId(String postId);
    Comment findByCommentId(String commentId);
    Comment deleteByCommentId(String commentId);
}