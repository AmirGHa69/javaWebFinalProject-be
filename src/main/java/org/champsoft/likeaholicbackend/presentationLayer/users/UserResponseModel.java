package org.champsoft.likeaholicbackend.presentationLayer.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponseModel {
    private String userId;
    private String userName;
    private String userEmail;
}
