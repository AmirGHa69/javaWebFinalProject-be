package org.champsoft.likeaholicbackend.presentationLayer.likes;
import org.champsoft.likeaholicbackend.businessLogicLayer.LikeService;
import org.champsoft.likeaholicbackend.dataAccessLayer.Like;
import org.champsoft.likeaholicbackend.presentationLayer.likes.LikeRequestModel;
import org.champsoft.likeaholicbackend.presentationLayer.likes.LikeResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping
    public LikeResponseModel addLike(@RequestBody LikeRequestModel likeRequest) {

        return likeService.addLike(likeRequest);
    }

    @DeleteMapping("/{id}")
    public void removeLike(@PathVariable Long id) {
        likeService.removeLike(id);
    }

    @GetMapping("/post/{postId}")
    public List<Like> getLikesByPostId(@PathVariable Long postId) {
        return likeService.getLikesByPostId(postId);
    }

    @GetMapping
    public List<Like> getAllLikes() {
        return likeService.getAllLikes();
    }
}
