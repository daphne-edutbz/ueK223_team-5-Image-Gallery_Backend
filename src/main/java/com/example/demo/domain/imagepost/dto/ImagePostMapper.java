package com.example.demo.domain.imagepost.dto;

import com.example.demo.core.generic.AbstractMapper;
import com.example.demo.domain.imagepost.ImagePost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ImagePostMapper extends AbstractMapper<ImagePost, ImagePostDTO> {
    @Override
    @Mapping(target = "authorId", source = "author.id")
    @Mapping(target = "likeCount", expression = "java(post.getLikedBy() == null ? 0 : post.getLikedBy().size())")
    ImagePostDTO toDTO(ImagePost post);

    ImagePost fromCreateDTO(ImagePostCreateDTO dto);
}
