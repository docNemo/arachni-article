package ru.mai.arachni.articles.core.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.mai.arachni.articles.core.domain.Article;

import java.time.LocalDate;
import java.util.List;

public class ArticleSpecification {
    public static Specification<Article> hasCreator(String creator) {
        return (article, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.lower(
                                article
                                .join("creator")
                                .get("creator")
                        ),
                        "%" + creator.toLowerCase() + "%"
                );
    }

    public static Specification<Article> hasTitle(String title) {
        return (article, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.lower(article.get("title")),
                        "%" + title.toLowerCase() + "%"
                );
    }

    public static Specification<Article> hasCategories(List<String> categories) {
        return (article, criteriaQuery, criteriaBuilder) ->
                article.
                        join("categories")
                        .get("category")
                        .in(categories);
    }

    public static Specification<Article> isLaterThan(LocalDate startDateTime) {
        return (article, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(
                        article.get("creationDate"),
                        startDateTime
                );

    }

    public static Specification<Article> isEarlierThan(LocalDate finishDateTime) {
        return (article, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(
                        article.get("creationDate"),
                        finishDateTime
                );

    }
}
