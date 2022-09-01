package com.eqy.devopsbot.entity.lark;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 18:30
 */
@Data
public class Sender {

    @JsonProperty("sender_id")
    private SenderId senderId;

    @JsonProperty("sender_type")
    private String senderType;

    @JsonProperty("tenant_key")
    private String tenantKey;
}
