package com.suportChat.project.controller.queueTicket;


import com.suportChat.project.service.queueTicket.QueueTicketService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name="/queue")
public class QueueTicketController {

    private final QueueTicketService queueTicketService;

    public QueueTicketController(QueueTicketService queueTicketService) {
        this.queueTicketService = queueTicketService;
    }



}
