package org.champsoft.likeaholicbackend.businessLogicLayer;

import jakarta.transaction.Transactional;
import org.champsoft.likeaholicbackend.dataAccessLayer.Post;
import org.champsoft.likeaholicbackend.dataAccessLayer.PostRepository;
import org.champsoft.likeaholicbackend.dataAccessLayer.User;
import org.champsoft.likeaholicbackend.dataAccessLayer.UserRepository;
import org.champsoft.likeaholicbackend.dataMapperLayer.PostResponseMapper;
import org.champsoft.likeaholicbackend.presentationLayer.posts.PostRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.posts.PostResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired private UserRepository userRepository;
    @Autowired
    PostResponseMapper postResponseMapper;


    @Override
    public PostResponseModel createPost(PostRequestModel postRequestModel) {
        // Fetch the User entity
        User user = userRepository.findByUserId(postRequestModel.getUserId());
        // Map the PostRequestModel to a Post entity
        Post post = new Post();
        post.setUser(user);
        post.setContent(postRequestModel.getContent());
        post.setImageUrl(postRequestModel.getImageUrl());

        // Generate a unique postId
//        post.setPostId(String.valueOf(System.currentTimeMillis())); // Use current time for uniqueness
        post.setPostId(UUID.randomUUID().toString()); // Use UUID for uniqueness


        // Save the Post entity
        postRepository.save(post);

        // Map the saved Post entity to a PostResponseModel and return it
        return postResponseMapper.entityToResponseModel(post);
    }



    @Override
    public Post updatePost(String id, Post post) {
        Post existingPost = postRepository.findByPostId(id);
        existingPost.setContent(post.getContent());
        existingPost.setImageUrl(post.getImageUrl());
        return postRepository.save(existingPost);
    }

    @Override
    public String deletePost(String id) {

        Post post = postRepository.findByPostId(id);
        String postId = post.getPostId();
        System.out.println(postId);
        System.out.println(post.getContent());
        this.postRepository.delete(post);
//        postRepository.deleteById(id);
        return ("Post: " + postId + " deleted");


    }

    @Override
    public List<Post> getPostsByUserId(String userId) {
        return postRepository.findByUser_UserId(userId);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}