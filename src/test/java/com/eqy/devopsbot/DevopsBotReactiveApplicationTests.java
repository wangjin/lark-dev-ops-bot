package com.eqy.devopsbot;

import com.eqy.devopsbot.service.LarkApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class DevopsBotReactiveApplicationTests {

    private final LarkApiService larkApiService;

    @Test
    void contextLoads() throws JsonProcessingException, InterruptedException {
        larkApiService.sendMessage("ou_49b75238f39e28dcf8a1b9829a58b6de", "interactive", "{\n" +
                "  \"config\": {\n" +
                "    \"wide_screen_mode\": true\n" +
                "  },\n" +
                "  \"header\": {\n" +
                "    \"template\": \"green\",\n" +
                "    \"title\": {\n" +
                "      \"content\": \"流水线任务\uD83C\uDF89\",\n" +
                "      \"tag\": \"plain_text\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"elements\": [\n" +
                "    {\n" +
                "      \"fields\": [\n" +
                "        {\n" +
                "          \"is_short\": false,\n" +
                "          \"text\": {\n" +
                "            \"content\": \"**\uD83D\uDCCC 项目：**\\n 智慧短信 / SMS Service\",\n" +
                "            \"tag\": \"lark_md\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"is_short\": true,\n" +
                "          \"text\": {\n" +
                "            \"content\": \"**⚡️ 分支：**\\n test\",\n" +
                "            \"tag\": \"lark_md\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"is_short\": true,\n" +
                "          \"text\": {\n" +
                "            \"content\": \"**\uD83D\uDE4B 发起人：**\\n libinguan_v🐖\",\n" +
                "            \"tag\": \"lark_md\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"is_short\": true,\n" +
                "          \"text\": {\n" +
                "            \"content\": \"**\uD83D\uDE4B 当前阶段：**\\n 部署-测试\",\n" +
                "            \"tag\": \"lark_md\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"is_short\": true,\n" +
                "          \"text\": {\n" +
                "            \"content\": \"**\uD83C\uDF24 当前状态：**\\n running\",\n" +
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
                "          \"url\": \"https://open.feishu.cn/\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"tag\": \"action\"\n" +
                "    }\n" +
                "  ]\n" +
                "}");

        TimeUnit.SECONDS.sleep(5);
    }

}
