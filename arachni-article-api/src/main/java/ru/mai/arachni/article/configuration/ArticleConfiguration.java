package ru.mai.arachni.article.configuration;

import ru.mai.arachni.article.converter.ArticleConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mai.arachni.article.core.repository.ArticleRepository;
import ru.mai.arachni.article.core.repository.CategoryRepository;
import ru.mai.arachni.article.core.repository.CreatorRepository;
import ru.mai.arachni.article.service.ArticleService;

@Configuration
public class ArticleConfiguration {

    @Bean
    public ArticleService articleService(
            ArticleRepository articleRepository,
            CreatorRepository creatorRepository,
            CategoryRepository categoryRepository,
            ArticleConverter articleConverter
    ) {
        return new ArticleService(
                articleConverter,
                articleRepository,
                creatorRepository,
                categoryRepository
        );
    }

    @Bean
    public ArticleConverter articleConverter() {
        return new ArticleConverter();
    }
}
