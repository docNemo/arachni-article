package ru.mai.arachni.articles.objectstorage.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import ru.mai.arachni.articles.objectstorage.service.ObjectStorageService;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class ObjectStorageScheduler {
    private final ObjectStorageService objectStorageService;

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.MINUTES)
    public void uploadAllTempText() {
        objectStorageService.uploadAllTempText();
    }
}
