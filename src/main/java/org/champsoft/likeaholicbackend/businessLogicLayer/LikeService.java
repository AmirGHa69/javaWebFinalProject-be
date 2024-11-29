package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.Like;
import org.champsoft.likeaholicbackend.presentationLayer.likes.LikeRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.likes.LikeResponseModel;

import java.util.List;

public interface LikeService {
    Like addLike(Like like);
    void removeLike(Long id);
    List<Like> getLikesByPostId(Long postId);
    List<Like> getAllLikes();
}