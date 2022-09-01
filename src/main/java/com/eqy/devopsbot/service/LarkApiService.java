package com.eqy.devopsbot.service;


import com.eqy.devopsbot.entity.lark.TenantAccessToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import reactor.core.publisher.Mono;

/**
 * 飞书API封装
 *
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 21:27
 */
public interface LarkApiService {

    Mono<TenantAccessToken> getTenantAccessToken();

    void sendMessage(String receiverId, String msgType, String message);
}
