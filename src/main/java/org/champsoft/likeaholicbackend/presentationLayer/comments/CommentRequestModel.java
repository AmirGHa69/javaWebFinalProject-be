package org.champsoft.likeaholicbackend.presentationLayer.comments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentRequestModel {
    private String postId;
    private String userId;
    private String content;
}
