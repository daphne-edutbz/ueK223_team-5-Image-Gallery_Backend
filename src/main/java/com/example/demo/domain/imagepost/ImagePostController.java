package com.example.demo.domain.imagepost;

import com.example.demo.domain.imagepost.dto.ImagePostCreateDTO;
import com.example.demo.domain.imagepost.dto.ImagePostDTO;
import com.example.demo.domain.imagepost.dto.ImagePostMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/image-posts")
@Validated
public class ImagePostController {

    private final ImagePostService service;
    private final ImagePostMapper mapper;

    public ImagePostController(ImagePostService service, ImagePostMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('IMAGE_CREATE')")
    public ResponseEntity<ImagePostDTO> create(
            @Validated @RequestBody ImagePostCreateDTO postDTO
    ) {
        ImagePost post = new ImagePost().setImageUrl(postDTO.imageUrl()).setDescription(postDTO.description());

        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(service.create(post)));
    }

    @GetMapping
    public Page<ImagePostDTO> getAll(Pageable pageable) {
        return service.findAll(pageable).map(mapper::toDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('IMAGE_MODIFY')")
    public ImagePostDTO update(@PathVariable UUID id, @RequestBody ImagePostCreateDTO postDTO) {
        ImagePost post = new ImagePost().setImageUrl(postDTO.imageUrl()).setDescription(postDTO.description());

        return mapper.toDTO(service.update(id, post));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('IMAGE_DELETE')")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/like")
    @PreAuthorize("hasAuthority('IMAGE_LIKE')")
    public ImagePostDTO toggleLike(@PathVariable UUID id) {
        return mapper.toDTO(service.toggleLike(id));
    }
}
