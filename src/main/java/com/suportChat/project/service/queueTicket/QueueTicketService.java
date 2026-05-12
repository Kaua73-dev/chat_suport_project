package com.suportChat.project.service.queueTicket;

import com.suportChat.project.exception.queue.QueueAlreadyExistServiceException;
import com.suportChat.project.exception.queue.QueueNoServiceException;
import com.suportChat.project.model.entity.QueueTicket;

import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueTicketService {


    // priority of queue
    private final PriorityQueue<QueueTicket> queueTickets = new PriorityQueue<>(
            Comparator.comparingInt(QueueTicket::getPriority)
                    .thenComparing(QueueTicket::getLocalDateTime)
    );

    private QueueTicket current;

    public QueueTicket callNext(){
        // remove last in order priority
        if(current != null){
            throw new QueueAlreadyExistServiceException();
        }

        current = queueTickets.poll();

        return current;
    }

    public void finish(){
        if(current == null){
            throw new QueueNoServiceException();
        }

        current = null;
    }

    public void add(QueueTicket ticket){
        // adding to queue
        queueTickets.add(ticket);
    }





}
