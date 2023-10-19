package ru.mai.arachni.articles.objectstorage.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
@Getter
public class ArachniObjectStorageException extends RuntimeException {
    private final ArachniObjectStorageError error;
    private final String extraInformation;

    @Override
    public String getMessage() {
        return "%s: %s: %s".formatted(error, error.getErrorMessage(), extraInformation);
    }
}
