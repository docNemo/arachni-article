package ru.mai.arachni.articles.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mai.arachni.articles.service.CategoryService;
import ru.mai.arachni.articles.core.repository.CategoryRepository;

@Configuration
public class CategoryConfiguration {

    @Bean
    public CategoryService categoryService(
            CategoryRepository categoryRepository
    ) {
        return new CategoryService(
                categoryRepository
        );
    }
}
