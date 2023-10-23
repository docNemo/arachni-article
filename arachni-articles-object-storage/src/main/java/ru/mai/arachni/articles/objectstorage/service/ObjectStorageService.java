package ru.mai.arachni.articles.objectstorage.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.mai.arachni.articles.objectstorage.dto.response.UploadFileResponse;
import ru.mai.arachni.articles.objectstorage.provider.ObjectStorageProvider;

@Slf4j
@RequiredArgsConstructor
public class ObjectStorageService {
    private final ObjectStorageProvider objectStorageProvider;

    public String getArticleText(String fileName) {
        return objectStorageProvider.downloadArticleText(fileName);
    }

    public UploadFileResponse saveArticleText(String fileName, String text) {
        return objectStorageProvider.uploadArticleText(fileName, text);
    }

    public void deleteArticleText(String fileName) {
        objectStorageProvider.deleteArticleText(fileName);
    }
}
