package ru.mai.arachni.article.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mai.arachni.article.core.domain.Creator;

import java.util.Optional;

public interface CreatorRepository extends JpaRepository<Creator, Long> {
    Optional<Creator> findOneCreatorsByCreator(String creator);

    Page<Creator> findByCreatorContainingIgnoreCase(String searchString, Pageable pageRequest);
}
