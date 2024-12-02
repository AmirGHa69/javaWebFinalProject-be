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
        // Fetch the User entity
        User user = userRepository.findByUserId(likeRequestModel.getUserId());
        // Fetch the Post entity
        Post post = postRepository.findByPostId(likeRequestModel.getPostId());
        // Map the LikeRequestModel to a Like entity
        Like like = new Like();
        like.setUser(user);
        like.setPost(post);

        // Set a non-null value for likeId
        like.setLikeId(String.valueOf(System.currentTimeMillis())); // Use current time for uniqueness

        // Save the Like entity
        likeRepository.save(like);

        // Map the saved Like entity to a LikeResponseModel and return it
        return likeResponseMapper.entityToResponseModel(like);
    }




    @Override
    public void removeLike(String id) {
        likeRepository.deleteByLikeId(id);
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