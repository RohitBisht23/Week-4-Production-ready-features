package com.ProductionReadyFeature.ProductionReadyFeature.Services.Implementations;

import com.ProductionReadyFeature.ProductionReadyFeature.DTO.PostDTO;
import com.ProductionReadyFeature.ProductionReadyFeature.Entities.PostEntity;
import com.ProductionReadyFeature.ProductionReadyFeature.Exceptions.ResourceNotFoundException;
import com.ProductionReadyFeature.ProductionReadyFeature.Repositories.PostRepository;
import com.ProductionReadyFeature.ProductionReadyFeature.Services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO postDTO) {
        PostEntity postEntity = modelMapper.map(postDTO, PostEntity.class);

        return modelMapper.map(postRepository.save(postEntity), PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long postId) {
        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post not found with this  id "+postId));

        return modelMapper.map(postEntity, PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO inputPost, Long postId) {
        PostEntity olderPost = postRepository
                .findById(postId)
                .orElseThrow(() ->new ResourceNotFoundException("Post not found with this  id "+postId));

        inputPost.setId(postId);
        modelMapper.map(inputPost, olderPost);

        return modelMapper.map(postRepository.save(olderPost), PostDTO.class);
    }
}
