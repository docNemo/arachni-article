package ru.mai.arachni.articles.dto.response.article;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class ArticleResponse {
    private Long idArticle;

    private String title;

    private List<String> categories;

    private String creator;

    private LocalDateTime creationDate;

    private String fileName;

    private String text;

    private boolean isCrawled;
}
