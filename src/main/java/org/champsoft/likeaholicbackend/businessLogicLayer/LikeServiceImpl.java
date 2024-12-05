package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.*;
import org.champsoft.likeaholicbackend.dataMapperLayer.LikeResponseMapper;
import org.champsoft.likeaholicbackend.presentationLayer.likes.LikeRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.likes.LikeResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LikeResponseMapper likeResponseMapper;

    @Override
    public LikeResponseModel addLike(LikeRequestModel likeRequestModel) {
        User user = userRepository.findByUserId(likeRequestModel.getUserId());
        Post post = postRepository.findByPostId(likeRequestModel.getPostId());

        Like like = new Like();
        like.setUser(user);
        like.setPost(post);
        like.setLikeId(String.valueOf(System.currentTimeMillis())); // Use current time for uniqueness
        likeRepository.save(like);
        return likeResponseMapper.entityToResponseModel(like);
    }


    @Override
    public void removeLike(String likeId) {
        Like like = this.likeRepository.findLikeByLikeId(likeId);
        System.out.println(like.getLikeId() + " : " + like.getPost().getContent());
        this.likeRepository.delete(like);
    }

    @Override
    public List<Like> getLikesByPostId(String postId) {
        return likeRepository.findByPost_PostId(postId);
    }

    @Override
    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }
}