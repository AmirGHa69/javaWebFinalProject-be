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
    private Long postId;
    private Long userId;
    private String content;
}
