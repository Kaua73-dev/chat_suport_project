package com.suportChat.project.model.entity;


import com.suportChat.project.model.roles.QueuTickerEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="queue_ticket")
public class QueueTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name", length = 30)
    private String name;

    private Integer priority;

    private String code;

    private LocalDateTime localDateTime;

    @Enumerated(EnumType.STRING)
    private QueuTickerEnum queuTickerEnum;

}
