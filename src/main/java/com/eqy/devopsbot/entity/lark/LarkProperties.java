package com.eqy.devopsbot.entity.lark;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 飞书应用配置
 *
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 17:49
 */
@Data
@ConfigurationProperties(prefix = "lark")
public class LarkProperties {

    private String appId;

    private String appSecret;

    private String verificationToken;

    private String encryptKey;

    private String larkHost;
}
