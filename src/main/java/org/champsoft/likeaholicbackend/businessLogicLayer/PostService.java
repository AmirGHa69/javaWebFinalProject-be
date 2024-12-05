package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.Post;
import org.champsoft.likeaholicbackend.presentationLayer.posts.PostRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.posts.PostResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {

    PostResponseModel createPost(PostRequestModel postRequestModel);
    ResponseEntity<?> updatePost(String postId, PostRequestModel postRequest);
    String deletePost(String postId);
    List<Post> getPostsByUserId(String userId);
    List<Post> getAllPosts();
}