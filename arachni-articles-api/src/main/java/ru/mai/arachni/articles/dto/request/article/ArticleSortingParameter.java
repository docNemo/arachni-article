package ru.mai.arachni.articles.dto.request.article;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ArticleSortingParameter {
    DATE("creationDate"),
    TITLE("title"),
    CREATOR("creator");

    private final String propertyName;
}
