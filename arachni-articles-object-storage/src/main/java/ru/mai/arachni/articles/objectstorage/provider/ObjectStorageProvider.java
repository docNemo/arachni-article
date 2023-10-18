package ru.mai.arachni.articles.objectstorage.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;
import ru.mai.arachni.articles.objectstorage.dto.request.UploadFileRequest;
import ru.mai.arachni.articles.objectstorage.dto.response.UploadFileResponse;

@RequiredArgsConstructor
public class ObjectStorageProvider {
    private final String objectStorageUploadUrl;
    private final String objectStorageDownloadUrl;

    private final RestTemplate restTemplate;

    public UploadFileResponse uploadArticleText(
            String fileName,
            String text
    ) {
        return restTemplate.postForObject(
                objectStorageUploadUrl,
                new UploadFileRequest(fileName, text),
                UploadFileResponse.class
        );
    }

    public String downloadArticleText(String fileName) {
        return restTemplate.getForObject(objectStorageDownloadUrl + "/" + fileName, String.class);
    }
}
