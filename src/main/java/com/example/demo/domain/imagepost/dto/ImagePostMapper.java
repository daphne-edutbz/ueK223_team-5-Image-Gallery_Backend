package com.example.demo.domain.imagepost.dto;

import com.example.demo.domain.imagepost.ImagePost;
import org.springframework.stereotype.Component;

@Component
public class ImagePostMapper {

    public ImagePostDTO toDTO(ImagePost post) {
        return new ImagePostDTO(
                post.getId(),
                post.getImageUrl(),
                post.getDescription(),
                post.getAuthor().getId(),
                post.getLikedBy().size(),
                post.getCreatedAt()
        );
    }
}
