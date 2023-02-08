package ru.yandex.practicum.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.PostService;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> findAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/posts/{postId}")
    public Post findPostById(@PathVariable("postId") Integer postId) {
        return postService.findPostById(postId);
    }

    @PostMapping(value = "/post")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }
}
