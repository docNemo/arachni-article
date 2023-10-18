package ru.mai.arachni.articles.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mai.arachni.articles.core.domain.TempText;

public interface TempTextRepository extends JpaRepository<TempText, Long> {
}
