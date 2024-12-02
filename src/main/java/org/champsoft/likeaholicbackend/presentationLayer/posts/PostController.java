package org.champsoft.likeaholicbackend.presentationLayer.posts;

import org.champsoft.likeaholicbackend.businessLogicLayer.PostService;
import org.champsoft.likeaholicbackend.dataAccessLayer.Post;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable String id) {
        System.out.println("Long id in controller: " + id);
        return postService.deletePost(id);

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