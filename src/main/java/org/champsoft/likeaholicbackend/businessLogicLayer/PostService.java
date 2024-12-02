package org.champsoft.likeaholicbackend.businessLogicLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.Post;
import org.champsoft.likeaholicbackend.presentationLayer.posts.PostRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.posts.PostResponseModel;

import java.util.List;

public interface PostService {

    PostResponseModel createPost(PostRequestModel postRequestModel);

    Post updatePost(Long id, Post post);
    void deletePost(Long id);
    List<Post> getPostsByUserId(Long userId);
    List<Post> getAllPosts();
}