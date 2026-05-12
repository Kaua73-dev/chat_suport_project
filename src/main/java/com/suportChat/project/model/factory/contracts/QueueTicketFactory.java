package com.suportChat.project.model.factory.contracts;

import com.suportChat.project.model.entity.QueueTicket;

public interface QueueTicketFactory {

    QueueTicket createTicket(String name);

}
