package org.champsoft.likeaholicbackend.dataMapperLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.Comment;
import org.champsoft.likeaholicbackend.presentationLayer.comments.CommentRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentRequestMapper {
    @Mapping(target = "id", ignore = true)
    Comment requestModelToEntity(CommentRequestModel commentRequestModel);
    List<Comment> requestModelListToEntityList(List<CommentRequestModel> commentRequestModels);
}