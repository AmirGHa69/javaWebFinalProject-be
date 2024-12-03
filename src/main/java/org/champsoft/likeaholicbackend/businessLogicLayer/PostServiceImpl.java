package org.champsoft.likeaholicbackend.businessLogicLayer;

import jakarta.transaction.Transactional;
import org.champsoft.likeaholicbackend.dataAccessLayer.*;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    PostResponseMapper postResponseMapper;
    @Autowired
    LikeService likeService;
    @Autowired
    CommentService commentService;
    @Autowired
    LikeRepository likeRepository;
    @Autowired
    CommentRepository commentRepository;



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
    @Transactional
    @Override
    public String deletePost(String postId) {
        // Fetch the post to ensure it exists
        Post post = postRepository.findByPostId(postId);
        if (post == null) {
            return "Post with ID " + postId + " not found.";
        }

        postId = post.getPostId();
//        System.out.println("Post to delete: " + postId);
//        System.out.println("Post content: " + post.getContent());

        List<Like> likes = likeService.getLikesByPostId(postId);
        for (Like like : likes) {
//            System.out.println("Deleting Like with ID: " + like.getLikeId());
            likeRepository.delete(like);
        }

        // Delete all comments associated with the post
        List<Comment> comments = commentService.getCommentsByPostId(postId);
        for (Comment comment : comments) {
//            System.out.println("Deleting Comment with ID: " + comment.getCommentId());
            commentRepository.delete(comment);
        }

        System.out.println("Deleting Post with ID: " + post.getPostId());
        postRepository.delete(post);
        postRepository.flush();  // Ensure the transaction is flushed and changes are committed


        return "Post deleted successfully";
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