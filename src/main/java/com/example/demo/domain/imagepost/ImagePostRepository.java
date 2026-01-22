package com.example.demo.domain.imagepost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository für ImagePost-Datenbankoperationen.
 */
@Repository
public interface ImagePostRepository extends JpaRepository<ImagePost, UUID> {
}
