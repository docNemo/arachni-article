package ru.mai.arachni.articles.objectstorage.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ArachniObjectStorageError {
    FAILED_DOWNLOAD_OBJECT(
            "Не удалось скачать объект",
            HttpStatus.BAD_REQUEST
    ),
    FAILED_UPLOAD_OBJECT(
            "Не удалось скачать объект",
            HttpStatus.BAD_REQUEST
    ),
    FAILED_DELETE_OBJECT(
            "Не удалось скачать объект",
            HttpStatus.BAD_REQUEST
    );

    private final String errorMessage;
    private final HttpStatus statusCode;
}
