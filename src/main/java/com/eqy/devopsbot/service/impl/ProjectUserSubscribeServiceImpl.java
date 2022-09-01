package com.eqy.devopsbot.service.impl;

import com.eqy.devopsbot.domain.ProjectUserSubscribe;
import com.eqy.devopsbot.domain.ProjectUserSubscribeRepository;
import com.eqy.devopsbot.service.ProjectUserSubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 22:17
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectUserSubscribeServiceImpl implements ProjectUserSubscribeService {

    private final ProjectUserSubscribeRepository projectUserSubscribeRepository;

    @Override
    public Mono<Void> addSubscribe(String openId, int projectId) {
        return isSubscribe(openId, projectId).flatMap(isSubscribe -> {
            if (Boolean.FALSE.equals(isSubscribe)) {
                ProjectUserSubscribe projectUserSubscribe = new ProjectUserSubscribe();
                projectUserSubscribe.setOpenId(openId);
                projectUserSubscribe.setProjectId(projectId);
                projectUserSubscribeRepository.save(projectUserSubscribe);
            }
            return Mono.empty();
        });
    }

    @Override
    public Mono<Void> deleteSubscribe(String openId, int projectId) {
        Flux.just(projectUserSubscribeRepository.findByOpenIdAndProjectId(openId, projectId))
                .subscribe(projectUserSubscribeRepository::deleteAll);
        return Mono.empty();
    }

    @Override
    public Mono<Boolean> isSubscribe(String openId, int projectId) {
        return Mono.just(projectUserSubscribeRepository.findByOpenIdAndProjectId(openId, projectId))
                .map(projectUserSubscribes -> !projectUserSubscribes.isEmpty());
    }
}
