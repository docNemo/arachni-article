package ru.mai.arachni.articles.objectstorage.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import ru.mai.arachni.articles.objectstorage.service.ObjectStorageService;

import java.util.concurrent.TimeUnit;
@Slf4j
@RequiredArgsConstructor
public class ObjectStorageScheduler {
    private final ObjectStorageService objectStorageService;

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.MINUTES)
    public void uploadAllTempText() {
        LOGGER.info("start transfer article's texts");
        objectStorageService.uploadAllTempText();
        LOGGER.info("successful transfer article's texts");
    }
}
