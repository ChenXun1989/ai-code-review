package wiki.chenxun.ai.code.review.boot.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import wiki.chenxun.ai.code.review.boot.controller.req.GitlabMergeRequestEvent;
import wiki.chenxun.ai.code.review.core.config.Config;
import wiki.chenxun.ai.code.review.boot.controller.res.GitLabMergeContentRes;
import wiki.chenxun.ai.code.review.core.model.PromptMessage;
import wiki.chenxun.ai.code.review.core.service.AiCodeReviewService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: chenxun
 * @date: 2025/4/24
 * @version: 1.0
 * @desc
 **/
@Slf4j
@RestController
public class GitlabController {

    @Autowired
    private Config config;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AiCodeReviewService aiCodeReviewService;


    @PostMapping("/gitlab/callback")
    @Validated()
    public void onMergeEvent(@RequestBody GitlabMergeRequestEvent event){
        log.info("gitlab merge request event:{}",event);

        // 转prompt
        List<GitLabMergeContentRes> res = getMergeContentResResponseEntity(event.getProject().getId(),
                event.getObjectAttributes().getIid());

        // 调用ai
        List<PromptMessage> prompts = new ArrayList<>();
        // 提示头
        PromptMessage promptMessage = new PromptMessage();
        promptMessage.setContent(config.getPromptTemplate().getHeader());
        prompts.add(promptMessage);
        // 内容
        prompts.addAll(res.stream().filter(i->
                 // 后缀过滤
                 config.getGitlab().getFileExtensions()
                        .stream().anyMatch(v->i.getNewPath().endsWith(v)))

                .map(i -> {
            PromptMessage p = new PromptMessage();
            p.setContent(i.getDiff());
            return p;
        }).collect(Collectors.toList()));

        String s= aiCodeReviewService.sendPrompt(prompts);
        createNote(event.getProject().getId(),event.getObjectAttributes().getIid(),s);
        
        aiCodeReviewService.sendNotification(s);
    }

    /**
     * 获取merge内容
     * @param projectId
     * @param mergeRequestId
     * @return
     */
    public List<GitLabMergeContentRes> getMergeContentResResponseEntity(Integer projectId,Integer mergeRequestId) {
        String url=String.format("%s/api/v4/projects/%s/merge_requests/%s/diffs?page=1&per_page=30",
                config.getGitlab().getHost(), projectId, mergeRequestId);
        HttpHeaders headers = new HttpHeaders();
        headers.set("PRIVATE-TOKEN", config.getGitlab().getToken());
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<List<GitLabMergeContentRes>> res = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<GitLabMergeContentRes>>(){});
        return res.getBody();
    }


    /**
     * POST /projects/:id/merge_requests/:merge_request_iid/notes
     *
     * @param projectId
     * @param mergeRequestId
     * @param comment
     */
    public void  createNote(Integer projectId,Integer mergeRequestId,String comment){
        String url=String.format("%s/api/v4/projects/%s/merge_requests/%s/notes",
                config.getGitlab().getHost(), projectId, mergeRequestId);

        Note note = new Note();
        note.setBody(comment);

        HttpHeaders headers = new HttpHeaders();
        headers.set("PRIVATE-TOKEN", config.getGitlab().getToken());
        HttpEntity<?> entity = new HttpEntity<>(note,headers);

        log.info("createNote url:{} comment {}",url, comment);
        restTemplate.exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<Void>(){});
    }

    @Data
    public static class Note {
        private String body;
    }


}
