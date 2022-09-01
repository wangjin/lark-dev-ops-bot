package com.eqy.devopsbot.entity.lark;

import lombok.Data;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 18:27
 */
@Data
public class Event {

    private EventMessage message;

    private Sender sender;
}
