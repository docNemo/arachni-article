package ru.mai.arachni.articles.objectstorage.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.mai.arachni.articles.objectstorage.dto.request.UploadFileRequest;
import ru.mai.arachni.articles.objectstorage.dto.response.UploadFileResponse;
import ru.mai.arachni.articles.objectstorage.exception.ArachniObjectStorageError;
import ru.mai.arachni.articles.objectstorage.exception.ArachniObjectStorageException;

@RequiredArgsConstructor
public class ObjectStorageProvider {
    private final String objectsUrl;

    private final RestTemplate restTemplate;

    public UploadFileResponse uploadArticleText(
            String fileName,
            String text
    ) {
        try {
            return restTemplate.postForObject(
                    objectsUrl,
                    new UploadFileRequest(fileName, text),
                    UploadFileResponse.class
            );
        } catch (ResourceAccessException | HttpStatusCodeException e) {
            throw new ArachniObjectStorageException(
                    ArachniObjectStorageError.FAILED_UPLOAD_OBJECT,
                    e.getMessage()
            );
        }
    }

    public String downloadArticleText(String fileName) {
        try {
            return restTemplate.getForObject(objectsUrl + "/" + fileName, String.class);
        } catch (ResourceAccessException | HttpStatusCodeException e) {
            throw new ArachniObjectStorageException(
                    ArachniObjectStorageError.FAILED_DOWNLOAD_OBJECT,
                    e.getMessage()
            );
        }
    }

    public void deleteArticleText(String fileName) {
        try {
            restTemplate.delete(objectsUrl + "/" + fileName);
        } catch (ResourceAccessException | HttpStatusCodeException e) {
            throw new ArachniObjectStorageException(
                    ArachniObjectStorageError.FAILED_DELETE_OBJECT,
                    e.getMessage()
            );
        }
    }
}
