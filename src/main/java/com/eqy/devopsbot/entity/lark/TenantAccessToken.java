package com.eqy.devopsbot.entity.lark;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 21:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantAccessToken {

    @JsonProperty("code")
    private int code;

    @JsonProperty("expire")
    private int expire;

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("tenant_access_token")
    private String accessToken;

    private long expireAt;
}
