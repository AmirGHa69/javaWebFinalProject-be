package org.champsoft.likeaholicbackend.presentationLayer.posts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.champsoft.likeaholicbackend.presentationLayer.comments.CommentResponseModel;
import org.champsoft.likeaholicbackend.presentationLayer.likes.LikeResponseModel;
import org.champsoft.likeaholicbackend.presentationLayer.users.UserResponseModel;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostResponseModel {
    private String postId;
    private UserResponseModel user;
    private String content;
    private String imageUrl;
    private List<LikeResponseModel> likes;
    private List<CommentResponseModel> comments;
//    private String timestamp;
}
