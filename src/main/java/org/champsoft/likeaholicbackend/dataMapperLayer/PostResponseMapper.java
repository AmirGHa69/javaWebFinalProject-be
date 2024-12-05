package org.champsoft.likeaholicbackend.dataMapperLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.Post;
import org.champsoft.likeaholicbackend.presentationLayer.posts.PostResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostResponseMapper {
    List<PostResponseModel> entityListToResponseModelList(List<Post> posts);
    PostResponseModel entityToResponseModel(Post post);
}