package com.eqy.devopsbot.service;

import reactor.core.publisher.Mono;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 22:17
 */
public interface ProjectUserSubscribeService {

    Mono<Void> addSubscribe(String openId, int projectId);

    Mono<Void> deleteSubscribe(String openId, int projectId);

    Mono<Boolean> isSubscribe(String openId, int projectId);
}
