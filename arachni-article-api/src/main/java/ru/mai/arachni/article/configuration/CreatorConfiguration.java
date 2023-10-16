package ru.mai.arachni.article.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mai.arachni.article.service.CreatorService;
import ru.mai.arachni.article.core.repository.CreatorRepository;

@Configuration
public class CreatorConfiguration {

    @Bean
    public CreatorService creatorService(
            CreatorRepository creatorRepository
    ) {
        return new CreatorService(
                creatorRepository
        );
    }
}
