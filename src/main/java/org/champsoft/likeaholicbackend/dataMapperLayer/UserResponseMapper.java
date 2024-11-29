package org.champsoft.likeaholicbackend.dataMapperLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.User;
import org.champsoft.likeaholicbackend.presentationLayer.users.UserResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    UserResponseModel entityToResponseModel(User user);
    List<UserResponseModel> entityListToResponseModelList(List<User> users);
}
