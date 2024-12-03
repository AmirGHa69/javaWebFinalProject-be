package org.champsoft.likeaholicbackend.presentationLayer.posts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostRequestModel {
    private String content;
    private String imageUrl;
    private String userId;
}
