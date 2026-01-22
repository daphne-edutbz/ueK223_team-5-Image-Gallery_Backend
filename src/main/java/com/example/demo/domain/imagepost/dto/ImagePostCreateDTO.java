package com.example.demo.domain.imagepost.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO für das Erstellen eines neuen ImagePosts.
 */
public record ImagePostCreateDTO (
        @NotBlank String imageUrl,
        @Size(max = 200) String description
        ) {}
