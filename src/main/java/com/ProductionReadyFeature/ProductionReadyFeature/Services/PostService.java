package com.ProductionReadyFeature.ProductionReadyFeature.Services;

import com.ProductionReadyFeature.ProductionReadyFeature.DTO.PostDTO;
import com.ProductionReadyFeature.ProductionReadyFeature.Entities.PostEntity;

import java.util.List;
import java.util.Optional;

public interface PostService {

    public List<PostDTO> getAllPosts();

    public PostDTO createNewPost(PostDTO postDTO);

    public PostDTO getPostById(Long id);

    PostDTO updatePost(PostDTO inputPost, Long postId);
}
