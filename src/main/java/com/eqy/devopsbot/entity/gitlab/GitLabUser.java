package com.eqy.devopsbot.entity.gitlab;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-05-06 09:55
 */
@Data
public class GitLabUser {

    private int id;

    private String name;

    private String username;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    private String email;
}
