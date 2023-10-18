package ru.mai.arachni.articles.objectstorage.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import ru.mai.arachni.articles.core.repository.TempTextRepository;
import ru.mai.arachni.articles.objectstorage.provider.ObjectStorageProvider;

@RequiredArgsConstructor
public class ObjectStorageService {
    private final ObjectStorageProvider objectStorageProvider;
    private final TempTextRepository tempTextRepository;

    @Transactional
    public void uploadAllTempText() {
        tempTextRepository
                .findAll()
                .parallelStream()
                .forEach(
                        tempText -> {
                            objectStorageProvider.uploadArticleText(
                                    tempText.getFileName(),
                                    tempText.getText()
                            );
                            tempTextRepository.deleteById(tempText.getId());
                        }
                );
    }
}
