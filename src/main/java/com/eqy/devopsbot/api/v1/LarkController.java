package com.eqy.devopsbot.api.v1;

import com.eqy.devopsbot.entity.lark.Message;
import com.eqy.devopsbot.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Jin Wang
 * @version 1.0
 * @since 2022-05-07 12:24
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/lark/v1")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LarkController {

    private final EventService eventService;

    @PostMapping(value = "/event")
    public Mono<Message> event(@RequestBody Message message) {
        if (log.isDebugEnabled()) {
            log.debug("Received message: {}", message);
        }
        if (!ObjectUtils.isEmpty(message.getChallenge())) {
            return Mono.just(message);
        } else {
            eventService.handleMessage(message);
        }
        String str = "This alert is from Spring Boot!";
        System.out.println(str);
        return Mono.empty();
    }
}
