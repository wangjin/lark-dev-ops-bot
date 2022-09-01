package com.eqy.devopsbot.entity.lark;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 18:29
 */
@Data
public class SenderId {

    @JsonProperty("open_id")
    private String openId;
    @JsonProperty("union_id")
    private String unionId;
    @JsonProperty("user_id")
    private String userId;
}
