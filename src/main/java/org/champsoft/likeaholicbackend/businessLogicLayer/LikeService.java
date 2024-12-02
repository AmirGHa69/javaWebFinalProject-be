package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.Like;
import org.champsoft.likeaholicbackend.presentationLayer.likes.LikeRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.likes.LikeResponseModel;

import java.util.List;

public interface LikeService {

    LikeResponseModel addLike(LikeRequestModel likeRequestModel);

    void removeLike(String id);
    List<Like> getLikesByPostId(String postId);
    List<Like> getAllLikes();

}