package org.champsoft.likeaholicbackend.presentationLayer.likes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LikeResponseModel {
    private String userId;
    private String userName;
}
