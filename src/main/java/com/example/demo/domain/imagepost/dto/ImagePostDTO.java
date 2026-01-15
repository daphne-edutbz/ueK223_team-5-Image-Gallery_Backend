package com.example.demo.domain.imagepost.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ImagePostDTO(
        UUID id,
        String imageUrl,
        String description,
        UUID authorId,
        int likeCount,
        LocalDateTime createdAt) {}
