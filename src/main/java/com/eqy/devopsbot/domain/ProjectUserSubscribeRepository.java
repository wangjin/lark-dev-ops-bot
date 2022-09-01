package com.eqy.devopsbot.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 22:15
 */
@Repository
public interface ProjectUserSubscribeRepository extends JpaRepository<ProjectUserSubscribe, Long> {

    Optional<ProjectUserSubscribe> findByOpenId(String openId);

    Optional<ProjectUserSubscribe> findByProjectId(int projectId);

    List<ProjectUserSubscribe> findByOpenIdAndProjectId(String openId, int projectId);
}
