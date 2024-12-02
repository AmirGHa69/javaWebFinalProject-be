package org.champsoft.likeaholicbackend.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByPost_PostId(String postId);
    Like findByPostAndUser(Post post, User user);
    Like findByLikeId (String likeId);
    Like deleteByLikeId (String likeId);
}