package ru.mai.arachni.articles.configuration;

import ru.mai.arachni.articles.converter.ArticleConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mai.arachni.articles.core.repository.ArticleRepository;
import ru.mai.arachni.articles.core.repository.CategoryRepository;
import ru.mai.arachni.articles.core.repository.CreatorRepository;
import ru.mai.arachni.articles.objectstorage.service.ObjectStorageService;
import ru.mai.arachni.articles.service.ArticleService;

@Configuration
public class ArticleConfiguration {

    @Bean
    public ArticleService articleService(
            ArticleRepository articleRepository,
            CreatorRepository creatorRepository,
            CategoryRepository categoryRepository,
            ArticleConverter articleConverter,
            ObjectStorageService objectStorageService
    ) {
        return new ArticleService(
                articleConverter,
                articleRepository,
                creatorRepository,
                categoryRepository,
                objectStorageService
        );
    }

    @Bean
    public ArticleConverter articleConverter() {
        return new ArticleConverter();
    }
}
