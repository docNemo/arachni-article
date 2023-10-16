package ru.mai.arachni.article.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mai.arachni.article.core.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findOneCategoryByCategory(String category);

    Page<Category> findByCategoryContainingIgnoreCase(String searchString, Pageable pageRequest);
}
