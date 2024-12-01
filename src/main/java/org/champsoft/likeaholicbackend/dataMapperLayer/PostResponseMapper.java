package org.champsoft.likeaholicbackend.dataMapperLayer;

import org.champsoft.likeaholicbackend.dataAccessLayer.Post;
import org.champsoft.likeaholicbackend.presentationLayer.posts.PostResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostResponseMapper {
//    @Mapping(target = "likes", expression = "java(post.getLikes().stream().map(like -> new LikeResponseModel(like.getUser().getUserId(), like.getUser().getUserName())).collect(Collectors.toList()))")
//    @Mapping(target = "comments", expression = "java(post.getComments().stream().map(comment -> new CommentResponseModel(comment.getUser().getUserId(), comment.getUser().getUserName(), comment.getContent())).collect(Collectors.toList()))")    PostResponseModel entityToResponseModel(Post post);
    List<PostResponseModel> entityListToResponseModelList(List<Post> posts);
}