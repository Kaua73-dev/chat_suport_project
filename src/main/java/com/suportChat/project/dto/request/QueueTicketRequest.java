package com.suportChat.project.dto.request;

import com.suportChat.project.model.roles.QueuTickerEnum;

public record QueueTicketRequest(String name, QueuTickerEnum queuTickerEnum) {
}
