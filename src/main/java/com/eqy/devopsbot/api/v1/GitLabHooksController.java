package com.eqy.devopsbot.api.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-05-06 09:40
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/gitlab/v1")
public class GitLabHooksController {

    @PostMapping(value = "/hooks")
    public Mono<Void> hooks(@RequestBody String body) {
        log.info("body: {}", body);
        String resp = "{\n" +
                "  \"object_kind\": \"build\",\n" +
                "  \"ref\": \"test\",\n" +
                "  \"tag\": false,\n" +
                "  \"before_sha\": \"83b7d7f7673e0c0148587fff2aab4b8fc7d24ea9\",\n" +
                "  \"sha\": \"45a12c40d3d7f8867f90aede3bb106272251385f\",\n" +
                "  \"build_id\": 29676,\n" +
                "  \"build_name\": \"部署-测试\",\n" +
                "  \"build_stage\": \"deploy\",\n" +
                "  \"build_status\": \"success\",\n" +
                "  \"build_created_at\": \"2022-05-05T15:59:15.925+08:00\",\n" +
                "  \"build_started_at\": \"2022-05-05T16:41:44.269+08:00\",\n" +
                "  \"build_finished_at\": \"2022-05-05T16:43:16.021+08:00\",\n" +
                "  \"build_duration\": 91.75206,\n" +
                "  \"build_queued_duration\": 17.086873,\n" +
                "  \"build_allow_failure\": false,\n" +
                "  \"build_failure_reason\": \"unknown_failure\",\n" +
                "  \"pipeline_id\": 8139,\n" +
                "  \"runner\": {\n" +
                "    \"id\": 175,\n" +
                "    \"description\": \"gitlab-runner-1-gitlab-runner-65dc74685d-dqnjd\",\n" +
                "    \"active\": true,\n" +
                "    \"tags\": [\n" +
                "      \"kubernetes-test\"\n" +
                "    ]\n" +
                "  },\n" +
                "  \"project_id\": 4507,\n" +
                "  \"project_name\": \"智慧短信 / SMS Admin\",\n" +
                "  \"user\": {\n" +
                "    \"id\": 3412,\n" +
                "    \"name\": \"hanzhilong_v\",\n" +
                "    \"username\": \"hanzhilong_v\",\n" +
                "    \"avatar_url\": \"https://www.gravatar.com/avatar/fef98954ac95bb4f183f6af950861df0?s=80\\u0026d=identicon\",\n" +
                "    \"email\": \"1519215647@qq.com\"\n" +
                "  },\n" +
                "  \"commit\": {\n" +
                "    \"id\": 8139,\n" +
                "    \"sha\": \"45a12c40d3d7f8867f90aede3bb106272251385f\",\n" +
                "    \"message\": \"Merge branch 'dev' into 'test'\\n\\nDev\\n\\nSee merge request intelligence-sms/sms-admin!725\",\n" +
                "    \"author_name\": \"hanzhilong_v\",\n" +
                "    \"author_email\": \"1519215647@qq.com\",\n" +
                "    \"author_url\": \"http://10.1.160.67/hanzhilong_v\",\n" +
                "    \"status\": \"success\",\n" +
                "    \"duration\": 2618,\n" +
                "    \"started_at\": \"2022-05-05T15:59:20.899+08:00\",\n" +
                "    \"finished_at\": \"2022-05-05T16:43:16.237+08:00\"\n" +
                "  },\n" +
                "  \"repository\": {\n" +
                "    \"name\": \"SMS Admin\",\n" +
                "    \"url\": \"ssh://git@10.1.160.67:10022/intelligence-sms/sms-admin.git\",\n" +
                "    \"description\": \"管理后台前端项目\",\n" +
                "    \"homepage\": \"http://10.1.160.67/intelligence-sms/sms-admin\",\n" +
                "    \"git_http_url\": \"http://10.1.160.67/intelligence-sms/sms-admin.git\",\n" +
                "    \"git_ssh_url\": \"ssh://git@10.1.160.67:10022/intelligence-sms/sms-admin.git\",\n" +
                "    \"visibility_level\": 0\n" +
                "  },\n" +
                "  \"environment\": null\n" +
                "}";
        return Mono.empty();
    }
}
