package ru.mai.arachni.articles.dto.response.article;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class ArticlePreviewResponse {
    private Long idArticle;
    private String title;
    private List<String> categories;
    private String creator;
    private ZonedDateTime creationDate;
    private String fileName;
    private boolean isCrawled;
}
