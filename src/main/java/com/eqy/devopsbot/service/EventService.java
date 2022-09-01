package com.eqy.devopsbot.service;


import com.eqy.devopsbot.entity.lark.Message;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 17:57
 */
public interface EventService {

    void handleMessage(Message event);
}
