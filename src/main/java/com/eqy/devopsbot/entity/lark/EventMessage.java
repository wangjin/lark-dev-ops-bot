package com.eqy.devopsbot.entity.lark;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 18:27
 */
@Data
public class EventMessage {
    @JsonProperty("chat_id")
    private String chatId;
    @JsonProperty("chat_type")
    private String chatType;
    @JsonProperty("content")
    private String content;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("message_id")
    private String messageId;
    @JsonProperty("message_type")
    private String messageType;
}
