package com.eqy.devopsbot.entity.lark;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 18:07
 */
@Data
public class MessageHeader {

    @JsonProperty("event_id")
    private String eventId;
    @JsonProperty("token")
    private String token;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("event_type")
    private String eventType;
    @JsonProperty("tenant_key")
    private String tenantKey;
    @JsonProperty("app_id")
    private String appId;
}
