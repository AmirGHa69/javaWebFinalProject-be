package org.champsoft.likeaholicbackend.presentationLayer.posts;

import org.champsoft.likeaholicbackend.businessLogicLayer.PostService;
import org.champsoft.likeaholicbackend.dataAccessLayer.Post;
import org.champsoft.likeaholicbackend.dataAccessLayer.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    PostRepository postRepository;

    @PostMapping
    public PostResponseModel createPost(@RequestBody PostRequestModel postRequestModel) {
        return postService.createPost(postRequestModel);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<?> updatePost(@PathVariable String postId, @RequestBody PostRequestModel postRequest) {
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

    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable String postId) {
        System.out.println("postId in controller: " + postId);
        return postService.deletePost(postId);

    }

    @GetMapping("/user/{userId}")
    public List<Post> getPostsByUserId(@PathVariable String userId) {
        return postService.getPostsByUserId(userId);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
}