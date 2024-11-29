package org.champsoft.likeaholicbackend.dataMapperLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.Like;
import org.champsoft.likeaholicbackend.presentationLayer.likes.LikeRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LikeRequestMapper {
    @Mapping(target = "id", ignore = true)
    Like requestModelToEntity(LikeRequestModel likeRequestModel);
    List<Like> requestModelListToEntityList(List<LikeRequestModel> likeRequestModels);
}