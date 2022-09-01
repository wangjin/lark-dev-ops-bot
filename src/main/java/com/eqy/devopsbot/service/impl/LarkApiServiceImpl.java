package com.eqy.devopsbot.service.impl;


import com.eqy.devopsbot.entity.lark.Auth;
import com.eqy.devopsbot.entity.lark.LarkProperties;
import com.eqy.devopsbot.entity.lark.SendMessage;
import com.eqy.devopsbot.entity.lark.TenantAccessToken;
import com.eqy.devopsbot.service.LarkApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 21:28
 */
@Slf4j
@Service
@EnableConfigurationProperties(LarkProperties.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LarkApiServiceImpl implements LarkApiService {

    /**
     * TENANT_ACCESS_TOKEN_URI
     */
    private static final String TENANT_ACCESS_TOKEN_URI = "/open-apis/auth/v3/tenant_access_token/internal";
    /**
     * MESSAGE_URI
     */
    private static final String MESSAGE_URI = "/open-apis/im/v1/messages?receive_id_type=open_id";
    private static final String PIPELINE_JOB_MSG_TEMPLATE = "{\n" +
            "  \"config\": {\n" +
            "    \"wide_screen_mode\": true\n" +
            "  },\n" +
            "  \"header\": {\n" +
            "    \"template\": \"%s\",\n" +
            "    \"title\": {\n" +
            "      \"content\": \"%s\uD83C\uDF89\",\n" +
            "      \"tag\": \"plain_text\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"elements\": [\n" +
            "    {\n" +
            "      \"fields\": [\n" +
            "        {\n" +
            "          \"is_short\": false,\n" +
            "          \"text\": {\n" +
            "            \"content\": \"**\uD83D\uDCCC 项目：**\\n %s\",\n" +
            "            \"tag\": \"lark_md\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"is_short\": true,\n" +
            "          \"text\": {\n" +
            "            \"content\": \"**⚡️ 分支：**\\n %s\",\n" +
            "            \"tag\": \"lark_md\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"is_short\": true,\n" +
            "          \"text\": {\n" +
            "            \"content\": \"**\uD83D\uDE4B 发起人：**\\n %s\",\n" +
            "            \"tag\": \"lark_md\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"is_short\": true,\n" +
            "          \"text\": {\n" +
            "            \"content\": \"**\uD83D\uDE4B 当前阶段：**\\n %s\",\n" +
            "            \"tag\": \"lark_md\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"is_short\": true,\n" +
            "          \"text\": {\n" +
            "            \"content\": \"**\uD83C\uDF24 当前状态：**\\n %s\",\n" +
            "            \"tag\": \"lark_md\"\n" +
            "          }\n" +
            "        }\n" +
            "      ],\n" +
            "      \"tag\": \"div\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"actions\": [\n" +
            "        {\n" +
            "          \"tag\": \"button\",\n" +
            "          \"text\": {\n" +
            "            \"content\": \"查看任务\",\n" +
            "            \"tag\": \"plain_text\"\n" +
            "          },\n" +
            "          \"type\": \"primary\",\n" +
            "          \"url\": \"%s\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"tag\": \"action\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    private final LarkProperties larkProperties;
    private final WebClient webClient;
    private TenantAccessToken accessToken;

    public Mono<TenantAccessToken> getTenantAccessToken() {

        // 判断AccessToken是否为空或过期
        if (accessToken != null && accessToken.getExpireAt() > System.currentTimeMillis()) {
            return Mono.just(accessToken);
        }
        return webClient
                .post()
                .uri(TENANT_ACCESS_TOKEN_URI)
                .body(Mono.just(new Auth(larkProperties.getAppId(), larkProperties.getAppSecret())), Auth.class)
                .retrieve()
                .bodyToMono(TenantAccessToken.class).map(tenantAccessToken -> {
                    this.accessToken = tenantAccessToken;
                    this.accessToken.setExpireAt(System.currentTimeMillis() + this.accessToken.getExpire() * 1000L - 1000);
                    return tenantAccessToken;
                });
    }

    public void sendMessage(String receiverId, String msgType, String message) {
        this.getTenantAccessToken()
                .subscribe(token -> webClient
                        .post()
                        .uri(MESSAGE_URI)
                        .header("Authorization", "Bearer " + token.getAccessToken())
                        .body(Mono.just(new SendMessage(receiverId, msgType, message)), SendMessage.class)
                        .retrieve()
                        .bodyToMono(String.class)
                        .subscribe(body -> log.info("body={}", body)));
    }
}
