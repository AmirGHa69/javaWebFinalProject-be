package org.champsoft.likeaholicbackend.presentationLayer.posts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostResponseModel {
    private String postId;
    private String content;
    private String imageUrl;
    private String timestamp;
}
