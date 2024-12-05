package org.champsoft.likeaholicbackend.businessLogicLayer;

import jakarta.transaction.Transactional;
import org.champsoft.likeaholicbackend.dataAccessLayer.*;
import org.champsoft.likeaholicbackend.dataMapperLayer.PostResponseMapper;
import org.champsoft.likeaholicbackend.presentationLayer.posts.PostRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.posts.PostResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> updatePost(String postId, PostRequestModel postRequest) {
        Post optionalPost = postRepository.findByPostId(postId);
        if (optionalPost != null) {
            // Authorization check
            if (!optionalPost.getUser().getUserId().equals(postRequest.getUserId())) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are not authorized to update this post.");
            }
            // Update post fields
            optionalPost.setContent(postRequest.getContent());
            optionalPost.setImageUrl(postRequest.getImageUrl());
            postRepository.save(optionalPost);

            return ResponseEntity.ok("Post updated successfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
    }
    @Transactional
    @Override
    public String deletePost(String postId) {
        Post post = postRepository.findByPostId(postId);
        if (post == null) {
            return "Post with ID " + postId + " not found.";
        }

        postId = post.getPostId();
//        System.out.println("Post to delete: " + postId);
//        System.out.println("Post content: " + post.getContent());

        List<Like> likes = likeService.getLikesByPostId(postId);
        //            System.out.println("Deleting Like with ID: " + like.getLikeId());
        likeRepository.deleteAll(likes);
        List<Comment> comments = commentService.getCommentsByPostId(postId);
        //            System.out.println("Deleting Comment with ID: " + comment.getCommentId());
        commentRepository.deleteAll(comments);

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