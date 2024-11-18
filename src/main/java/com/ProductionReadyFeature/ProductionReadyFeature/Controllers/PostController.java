package com.ProductionReadyFeature.ProductionReadyFeature.Controllers;

import com.ProductionReadyFeature.ProductionReadyFeature.DTO.PostDTO;
import com.ProductionReadyFeature.ProductionReadyFeature.Services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostDTO getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PostMapping
    public PostDTO createNewPost(@RequestBody PostDTO postDTO) {
        return postService.createNewPost(postDTO);
    }

    @PutMapping("/{postId}")
    public PostDTO updatePost(@RequestBody PostDTO inputPost, @PathVariable Long postId) {
        return postService.updatePost(inputPost, postId);
    }
}
