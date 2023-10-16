package ru.mai.arachni.articles.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mai.arachni.articles.service.CreatorService;
import ru.mai.arachni.articles.core.repository.CreatorRepository;

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
