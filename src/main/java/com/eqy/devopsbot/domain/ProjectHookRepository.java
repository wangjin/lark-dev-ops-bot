package com.eqy.devopsbot.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-05-05 16:20
 */
@Repository
public interface ProjectHookRepository extends JpaRepository<ProjectHook, Long> {

    Optional<ProjectHook> findByProjectIdAndHookId(int projectId, int hookId);

}
