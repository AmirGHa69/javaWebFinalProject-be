package org.champsoft.likeaholicbackend.presentationLayer.likes;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LikeRequestModel {
    private String postId;
    private String userId;

}
