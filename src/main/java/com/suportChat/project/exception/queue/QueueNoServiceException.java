package com.suportChat.project.exception.queue;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class QueueNoServiceException extends RuntimeException {
    public QueueNoServiceException() {
        super("no service now");
    }
}
