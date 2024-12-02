package org.champsoft.likeaholicbackend.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
   List<Post> findByUser_UserId(String userId);
   Post deleteByUser_UserId(String userId);
   Post findByPostId (String postId);
   Post deleteByPostId(String postId);
}