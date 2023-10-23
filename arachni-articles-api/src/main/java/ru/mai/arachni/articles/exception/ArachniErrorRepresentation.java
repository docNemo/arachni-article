package ru.mai.arachni.articles.exception;

import lombok.Value;

@Value
public class ArachniErrorRepresentation {
    String errorCode;
    String message;
}
