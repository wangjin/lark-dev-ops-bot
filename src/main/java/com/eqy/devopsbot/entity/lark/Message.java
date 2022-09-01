package com.eqy.devopsbot.entity.lark;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 17:56
 */
@Data
public class Message {

    private String challenge;

    private String token;

    private String type;

    private String schema;

    @JsonProperty("header")
    private MessageHeader messageHeader;

    private Event event;
}
