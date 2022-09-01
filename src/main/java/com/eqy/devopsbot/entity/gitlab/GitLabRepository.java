package com.eqy.devopsbot.entity.gitlab;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-05-06 09:59
 */
@Data
public class GitLabRepository {

    private String name;

    private String url;

    private String description;

    private String homepage;

    @JsonProperty("git_http_url")
    private String gitHttpUrl;

    @JsonProperty("git_ssh_url")
    private String gitSshUrl;
}
