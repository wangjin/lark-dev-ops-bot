package com.eqy.devopsbot.config;

import com.eqy.devopsbot.entity.lark.LarkProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-05-07 15:50
 */
@Configuration
@EnableConfigurationProperties(LarkProperties.class)
public class WebClientConfig {

    @Bean
    public WebClient webClient(LarkProperties larkProperties) {
        return WebClient.builder()
                .baseUrl(larkProperties.getLarkHost())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
