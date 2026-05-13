package com.suportChat.project.model.factory.implementations;

import com.suportChat.project.model.entity.QueueTicket;
import com.suportChat.project.model.factory.contracts.QueueTicketFactory;
import com.suportChat.project.model.repository.QueueTickerRepository;
import com.suportChat.project.model.roles.QueuTickerEnum;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class PreferentialQueueTicketFactory implements QueueTicketFactory {

    private final QueueTickerRepository queueTickerRepository;

    public PreferentialQueueTicketFactory(QueueTickerRepository queueTickerRepository) {
        this.queueTickerRepository = queueTickerRepository;
    }


    @Override
    public QueueTicket createTicket(String name) {
        QueueTicket queueTicket = new QueueTicket();
        queueTicket.setName(name);
        queueTicket.setPriority(1);
        queueTicket.setCode(generateCode());
        queueTicket.setLocalDateTime(LocalDateTime.now());
        queueTicket.setQueuTickerEnum(QueuTickerEnum.PREFERENTIAL);

        queueTickerRepository.save(queueTicket);


        return queueTicket;
    }


    private String generateCode(){
        String chars ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code = new StringBuilder();

        Random random = new Random();

        for(int i = 0; i < 4; i++){
            int index = random.nextInt(chars.length());
            code.append(chars.charAt(index));


        }

        return code.toString();
    }



}
