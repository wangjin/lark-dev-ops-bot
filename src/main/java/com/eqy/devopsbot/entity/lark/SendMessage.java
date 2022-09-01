package com.eqy.devopsbot.entity.lark;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 21:55
 */
@Data
@AllArgsConstructor
public class SendMessage {

    @JsonProperty("receive_id")
    private String receiveId;

    @JsonProperty("msg_type")
    private String msgType;

    private String content;
}
