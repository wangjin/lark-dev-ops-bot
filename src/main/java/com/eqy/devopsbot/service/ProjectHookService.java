package com.eqy.devopsbot.service;


import com.eqy.devopsbot.domain.ProjectHook;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-05-05 16:22
 */
public interface ProjectHookService {

    Mono<Optional<ProjectHook>> findByProjectIdAndHookId(int projectId, int hookId);
}
