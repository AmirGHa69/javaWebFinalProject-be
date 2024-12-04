package org.champsoft.likeaholicbackend.presentationLayer.likes;
import org.champsoft.likeaholicbackend.businessLogicLayer.LikeService;
import org.champsoft.likeaholicbackend.dataAccessLayer.Like;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping("/{likeId}")
    public void removeLike(@PathVariable String likeId) {
        likeService.removeLike(likeId);
    }

    @GetMapping("/post/{postId}")
    public List<Like> getLikesByPostId(@PathVariable String postId) {
        return likeService.getLikesByPostId(postId);
    }

    @GetMapping
    public List<Like> getAllLikes() {
        return likeService.getAllLikes();
    }
}
