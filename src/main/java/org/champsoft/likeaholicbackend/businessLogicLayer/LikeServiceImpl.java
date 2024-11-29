package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.businessLogicLayer.LikeService;
import org.champsoft.likeaholicbackend.dataAccessLayer.Like;
import org.champsoft.likeaholicbackend.dataAccessLayer.LikeRepository;
import org.champsoft.likeaholicbackend.dataAccessLayer.User;
import org.champsoft.likeaholicbackend.dataMapperLayer.LikeRequestMapper;
import org.champsoft.likeaholicbackend.dataMapperLayer.LikeResponseMapper;
import org.champsoft.likeaholicbackend.presentationLayer.likes.LikeRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.likes.LikeResponseModel;
import org.champsoft.likeaholicbackend.presentationLayer.users.UserResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Override
    public Like addLike(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public void removeLike(Long id) {
        likeRepository.deleteById(id);
    }

    @Override
    public List<Like> getLikesByPostId(Long postId) {
        return likeRepository.findByPostId(postId);
    }

    @Override
    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }
}