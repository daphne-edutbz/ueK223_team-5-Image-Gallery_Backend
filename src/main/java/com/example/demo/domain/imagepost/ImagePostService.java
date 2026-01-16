package com.example.demo.domain.imagepost;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface ImagePostService {

    ImagePost create(ImagePost post);

    ImagePost update(UUID id, ImagePost updatedPost);

    void delete(UUID id);

    Page<ImagePost> findAll(Pageable pageable);

    ImagePost toggleLike(UUID postId);
}
