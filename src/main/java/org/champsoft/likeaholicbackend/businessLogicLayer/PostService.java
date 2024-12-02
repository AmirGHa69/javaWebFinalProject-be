package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.Post;
import org.champsoft.likeaholicbackend.presentationLayer.posts.PostRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.posts.PostResponseModel;

import java.util.List;

public interface PostService {

    PostResponseModel createPost(PostRequestModel postRequestModel);

    Post updatePost(String id, Post post);
    String deletePost(String id);
    List<Post> getPostsByUserId(String userId);
    List<Post> getAllPosts();
}