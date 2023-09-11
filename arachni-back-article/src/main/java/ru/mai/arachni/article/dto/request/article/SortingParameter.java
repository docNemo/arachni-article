package ru.mai.arachni.article.dto.request.article;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SortingParameter {
    DATE("creationDate"),
    TITLE("title"),
    CREATOR("creator");

    private final String propertyName;
}
