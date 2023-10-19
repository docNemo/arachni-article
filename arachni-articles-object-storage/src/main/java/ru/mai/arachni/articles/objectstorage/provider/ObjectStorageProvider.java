package ru.mai.arachni.articles.objectstorage.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;
import ru.mai.arachni.articles.objectstorage.dto.request.UploadFileRequest;
import ru.mai.arachni.articles.objectstorage.dto.response.UploadFileResponse;

@RequiredArgsConstructor
public class ObjectStorageProvider {
    private final String objectsUrl;

    private final RestTemplate restTemplate;

    public UploadFileResponse uploadArticleText(
            String fileName,
            String text
    ) {
        return restTemplate.postForObject(
                objectsUrl,
                new UploadFileRequest(fileName, text),
                UploadFileResponse.class
        );
    }

    public String downloadArticleText(String fileName) {
        return restTemplate.getForObject(objectsUrl + "/" + fileName, String.class);
    }

    public void deleteArticleText(String fileName) {
        restTemplate.delete(objectsUrl + "/" + fileName);
    }
}
