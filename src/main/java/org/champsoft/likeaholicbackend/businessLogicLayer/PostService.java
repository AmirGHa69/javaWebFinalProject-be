package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.Post;
import org.champsoft.likeaholicbackend.presentationLayer.posts.PostRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.posts.PostResponseModel;

import java.util.List;

public interface PostService {

    PostResponseModel createPost(PostRequestModel postRequestModel);

    Post updatePost(String postId, Post post);
    String deletePost(String postId);
    List<Post> getPostsByUserId(String userId);
    List<Post> getAllPosts();
}