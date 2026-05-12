package com.suportChat.project.exception.queue;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class QueueAlreadyExistServiceException extends RuntimeException {
    public QueueAlreadyExistServiceException() {
        super("There is still service available in the queue. ");
    }
}
