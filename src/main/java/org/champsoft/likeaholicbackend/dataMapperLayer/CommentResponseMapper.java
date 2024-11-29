package org.champsoft.likeaholicbackend.dataMapperLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.Comment;
import org.champsoft.likeaholicbackend.presentationLayer.comments.CommentResponseModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentResponseMapper {
    CommentResponseModel entityToResponseModel(Comment comment);
    List<CommentResponseModel> entityListToResponseModelList(List<Comment> comments);
}