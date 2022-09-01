package com.eqy.devopsbot.entity.gitlab;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-05-06 09:53
 */
@Data
public class GitLabJobEvent {

    private String ref;

    @JsonProperty("build_name")
    private String buildName;

    @JsonProperty("build_stage")
    private String buildStage;

    @JsonProperty("build_status")
    private String buildStatus;

    @JsonProperty("build_created_at")
    private String buildCreatedAt;

    @JsonProperty("build_started_at")
    private String buildStartedAt;

    @JsonProperty("build_finished_at")
    private String buildFinishedAt;

    @JsonProperty("build_duration")
    private String buildDuration;

    @JsonProperty("build_queued_duration")
    private String buildQueuedDuration;

    private GitLabUser user;

    private GitLabRepository repository;

    private String environment;
}
