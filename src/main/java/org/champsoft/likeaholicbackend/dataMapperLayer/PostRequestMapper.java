package org.champsoft.likeaholicbackend.dataMapperLayer;


import org.champsoft.likeaholicbackend.dataAccessLayer.Post;
import org.champsoft.likeaholicbackend.presentationLayer.posts.PostRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostRequestMapper {
    @Mapping(target = "id", ignore = true)
    Post requestModelToEntity(PostRequestModel postRequestModel);
    List<Post> requestModelListToEntityList(List<PostRequestModel> postRequestModels);
}
