package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.*;
import org.champsoft.likeaholicbackend.dataMapperLayer.LikeResponseMapper;
import org.champsoft.likeaholicbackend.presentationLayer.likes.LikeRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.likes.LikeResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

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
        User user = userRepository.findById(likeRequestModel.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + likeRequestModel.getUserId()));

        // Fetch the Post entity
        Post post = postRepository.findById(likeRequestModel.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found with ID: " + likeRequestModel.getPostId()));

        // Map the LikeRequestModel to a Like entity
        Like like = new Like();
        like.setUser(user);
        like.setPost(post);

        // Set a non-null value for likeId
        like.setLikeId(System.currentTimeMillis()); // Use current time for uniqueness

        // Save the Like entity
        likeRepository.save(like);

        // Map the saved Like entity to a LikeResponseModel and return it
        return likeResponseMapper.entityToResponseModel(like);
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