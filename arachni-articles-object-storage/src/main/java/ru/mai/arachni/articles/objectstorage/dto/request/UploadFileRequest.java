package ru.mai.arachni.articles.objectstorage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadFileRequest {
    private String objectName;
    private String text;
}
