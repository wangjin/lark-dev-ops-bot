package com.eqy.devopsbot.service.impl;


import com.eqy.devopsbot.entity.lark.Message;
import com.eqy.devopsbot.entity.lark.MsgContent;
import com.eqy.devopsbot.service.EventService;
import com.eqy.devopsbot.service.LarkApiService;
import com.eqy.devopsbot.service.ProjectUserSubscribeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 17:57
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventServiceImpl implements EventService {

    private final LarkApiService larkApiService;
    private final ObjectMapper objectMapper;
    private final ProjectUserSubscribeService projectUserSubscribeService;

    @Override
    @SneakyThrows
    public void handleMessage(Message message) {
        String text = objectMapper.readValue(message.getEvent().getMessage().getContent(), MsgContent.class).getText();
        MsgContent msgContent = new MsgContent();
        if (text.startsWith("/订阅")) {
            if (text.equals("/订阅")) {
                msgContent.setText("订阅格式：\n/订阅 <项目ID>\n例如：/订阅 123456");
            } else {
                String[] split = text.split(" ");
                if (split.length == 2) {
                    projectUserSubscribeService.addSubscribe(message.getEvent().getSender().getSenderId().getOpenId(), Integer.parseInt(split[1]));
                    msgContent.setText(String.format("订阅项目%s成功!", split[1]));
                } else {
                    msgContent.setText("订阅格式有误\n正确格式：\n/订阅 <项目ID>\n例如：/订阅 123456");
                }
            }

        }
        larkApiService.sendMessage(message.getEvent().getSender().getSenderId().getOpenId(), "text", objectMapper.writeValueAsString(msgContent));
    }
}
