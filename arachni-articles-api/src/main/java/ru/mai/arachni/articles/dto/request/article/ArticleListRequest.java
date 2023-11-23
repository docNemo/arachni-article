package ru.mai.arachni.articles.dto.request.article;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import ru.mai.arachni.articles.dto.request.PaginationRequest;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class ArticleListRequest extends PaginationRequest {
    private ArticleSortingParameter sortBy;
    private String creator;
    private List<String> categories;
    private LocalDate startDate;
    private LocalDate finishDate;
}
