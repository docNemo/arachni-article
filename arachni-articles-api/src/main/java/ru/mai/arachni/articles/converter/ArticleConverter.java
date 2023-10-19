package ru.mai.arachni.articles.converter;

import ru.mai.arachni.articles.dto.response.article.ArticlePreviewResponse;
import ru.mai.arachni.articles.dto.response.article.ArticleResponse;
import ru.mai.arachni.articles.core.domain.Article;
import ru.mai.arachni.articles.core.domain.Category;

import java.util.stream.Collectors;

public class ArticleConverter {
    public ArticleResponse convertArticleToArticleResponse(Article article, String text) {
        return new ArticleResponse(
                article.getIdArticle(),
                article.getTitle(),
                article
                        .getCategories()
                        .stream()
                        .map(Category::getCategory)
                        .collect(Collectors.toList()),
                article.getCreator().getCreator(),
                article.getCreationDate(),
                text
        );
    }

    public ArticlePreviewResponse convertArticleToArticlePreviewResponse(Article article) {
        return new ArticlePreviewResponse(
                article.getIdArticle(),
                article.getTitle(),
                article
                        .getCategories()
                        .stream()
                        .map(Category::getCategory)
                        .collect(Collectors.toList()),
                article.getCreator().getCreator(),
                article.getCreationDate(),
                article.getFileName()
        );
    }
}
