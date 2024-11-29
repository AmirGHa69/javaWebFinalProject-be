package org.champsoft.likeaholicbackend.dataMapperLayer;


import org.champsoft.likeaholicbackend.dataAccessLayer.User;
import org.champsoft.likeaholicbackend.presentationLayer.users.UserRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {
    @Mapping(target = "id", ignore = true)
    User requestModelToEntity(UserRequestModel userRequestModel);
    List<User> requestModelListToEntityList(List<UserRequestModel> userRequestModels);
}
