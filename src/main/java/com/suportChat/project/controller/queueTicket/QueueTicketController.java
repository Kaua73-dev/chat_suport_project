package com.suportChat.project.controller.queueTicket;


import com.suportChat.project.dto.request.QueueTicketRequest;
import com.suportChat.project.model.entity.QueueTicket;
import com.suportChat.project.model.factory.contracts.QueueTicketFactory;
import com.suportChat.project.model.factory.implementations.DefaultQueueTicketFactory;
import com.suportChat.project.model.factory.implementations.PcdQueueTicketFactory;
import com.suportChat.project.model.factory.implementations.PreferentialQueueTicketFactory;
import com.suportChat.project.model.roles.QueuTickerEnum;
import com.suportChat.project.service.queueTicket.QueueTicketService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/queue")
public class QueueTicketController {

    private final QueueTicketService queueTicketService;
    private final PcdQueueTicketFactory pcdQueueTicketFactory;
    private final PreferentialQueueTicketFactory preferentialQueueTicketFactory;
    private final DefaultQueueTicketFactory defaultQueueTicketFactory;


    public QueueTicketController(QueueTicketService queueTicketService, PcdQueueTicketFactory pcdQueueTicketFactory, PreferentialQueueTicketFactory preferentialQueueTicketFactory, DefaultQueueTicketFactory defaultQueueTicketFactory) {
        this.queueTicketService = queueTicketService;
        this.pcdQueueTicketFactory = pcdQueueTicketFactory;
        this.preferentialQueueTicketFactory = preferentialQueueTicketFactory;
        this.defaultQueueTicketFactory = defaultQueueTicketFactory;
    }

    @GetMapping("/next")
    public QueueTicket callNext(){
       return queueTicketService.callNext();
    }

    @PostMapping("/finish")
    public void finish(){
        queueTicketService.finish();
    }

    @PostMapping("/createTicket")
    public QueueTicket createTicket(@RequestBody QueueTicketRequest request){

        QueueTicket ticket;

        if(request.queuTickerEnum().equals(QueuTickerEnum.PCD)){
            ticket =
            pcdQueueTicketFactory.createTicket(request.name());
            queueTicketService.addToQueue(ticket);

        } else if(request.queuTickerEnum().equals(QueuTickerEnum.PREFERENTIAL)){
            ticket =
                    preferentialQueueTicketFactory.createTicket(request.name());
            queueTicketService.addToQueue(ticket);

        } else {
            ticket =
                    defaultQueueTicketFactory.createTicket(request.name());
            queueTicketService.addToQueue(ticket);
        }

        return ticket;

    }


}
