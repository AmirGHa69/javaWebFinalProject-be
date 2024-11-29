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
    private Long userId;
    private Long postId;
}
