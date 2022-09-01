package com.eqy.devopsbot.service.impl;


import com.eqy.devopsbot.domain.ProjectHook;
import com.eqy.devopsbot.domain.ProjectHookRepository;
import com.eqy.devopsbot.service.ProjectHookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-05-05 16:22
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectHookServiceImpl implements ProjectHookService {

    private final ProjectHookRepository projectHookRepository;

    @Override
    public Mono<Optional<ProjectHook>> findByProjectIdAndHookId(int projectId, int hookId) {
        return Mono.just(projectHookRepository.findByProjectIdAndHookId(projectId, hookId));
    }
}
