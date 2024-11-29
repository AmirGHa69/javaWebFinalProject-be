package org.champsoft.likeaholicbackend.dataMapperLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.Like;
import org.champsoft.likeaholicbackend.presentationLayer.likes.LikeResponseModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LikeResponseMapper {
    LikeResponseModel entityToResponseModel(Like like);
    List<LikeResponseModel> entityListToResponseModelList(List<Like> likes);
}