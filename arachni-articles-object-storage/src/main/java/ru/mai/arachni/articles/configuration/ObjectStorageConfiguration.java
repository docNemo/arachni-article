package ru.mai.arachni.articles.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import ru.mai.arachni.articles.core.repository.TempTextRepository;
import ru.mai.arachni.articles.objectstorage.provider.ObjectStorageProvider;
import ru.mai.arachni.articles.objectstorage.scheduler.ObjectStorageScheduler;
import ru.mai.arachni.articles.objectstorage.service.ObjectStorageService;

@Configuration
@EnableScheduling
public class ObjectStorageConfiguration {

    @Bean
    public ObjectStorageProvider objectStorageProvider(
            @Value("${objectstorage.uploadUrl}") String objectStorageUploadUrl,
            @Value("${objectstorage.downloadUrl}")String objectStorageDownloadUrl,
            RestTemplate restTemplate
    ) {
        return new ObjectStorageProvider(
                objectStorageUploadUrl,
                objectStorageDownloadUrl,
                restTemplate
        );
    }

    @Bean
    public ObjectStorageService objectStorageService(
            ObjectStorageProvider objectStorageProvider,
            TempTextRepository tempTextRepository
    ) {
        return new ObjectStorageService(
                objectStorageProvider,
                tempTextRepository
        );
    }

    @Bean
    public ObjectStorageScheduler objectStorageScheduler(
            ObjectStorageService objectStorageService
    ) {
        return new ObjectStorageScheduler(
                objectStorageService
        );
    }
}
