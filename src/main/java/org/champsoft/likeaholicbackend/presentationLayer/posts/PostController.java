package org.champsoft.likeaholicbackend.presentationLayer.posts;

import org.champsoft.likeaholicbackend.businessLogicLayer.PostService;
import org.champsoft.likeaholicbackend.dataAccessLayer.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;


    @PostMapping
    public PostResponseModel createPost(@RequestBody PostRequestModel postRequestModel) {
        return postService.createPost(postRequestModel);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<?> updatePost(@PathVariable String postId, @RequestBody PostRequestModel postRequest) {

        return postService.updatePost(postId, postRequest);
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