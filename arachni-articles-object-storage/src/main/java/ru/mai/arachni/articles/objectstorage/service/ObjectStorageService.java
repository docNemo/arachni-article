package ru.mai.arachni.articles.objectstorage.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import ru.mai.arachni.articles.core.domain.TempText;
import ru.mai.arachni.articles.core.repository.TempTextRepository;
import ru.mai.arachni.articles.objectstorage.provider.ObjectStorageProvider;

@Slf4j
@RequiredArgsConstructor
public class ObjectStorageService {
    private final ObjectStorageProvider objectStorageProvider;
    private final TempTextRepository tempTextRepository;

    @Transactional
    public void uploadAllTempText() {
        Page<TempText> page = null;
        do {
            page = tempTextRepository
                    .findAll(Pageable.ofSize(25));
            page.forEach(
                    tempText -> {
                        objectStorageProvider.uploadArticleText(
                                tempText.getFileName(),
                                tempText.getText()
                        );
                        tempTextRepository.deleteById(tempText.getId());
                    }
            );
            LOGGER.info("transfer {} texts", page.getSize());
        } while (page.hasNext());
    }

    public String getArticleText(String fileName) {
        return objectStorageProvider.downloadArticleText(fileName);
    }
}
