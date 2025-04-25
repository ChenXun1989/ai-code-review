package wiki.chenxun.ai.code.review.core.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiki.chenxun.ai.code.review.core.config.Config;
import wiki.chenxun.ai.code.review.core.model.PromptMessage;

import java.util.List;

/**
 * @author: chenxun
 * @date: 2025/4/24
 * @version: 1.0
 * @desc
 **/
@Slf4j
@Component
public class AiCodeReviewService {

    @Autowired
    private List<LlmService> llmServiceList;

    @Autowired
    private Config config;

    @Autowired
    private List<NoticeService> noticeServiceList;

    /**
     * 发送prompt
     * @param promptMessages
     * @return
     */
    public String sendPrompt(List<PromptMessage> promptMessages){
        LlmService llmService=  llmServiceList.stream().filter(i->
                config.getLlmType().equals(i.code()))
                .findFirst().orElseThrow(()->new RuntimeException("llmService not found"));

        return llmService.sendPrompt(promptMessages);
    }

    public String sendNotification(String comment){
        NoticeService noticeService=  noticeServiceList.stream().filter(i->
                config.getNoticeType().equals(i.code()))
                .findFirst().orElse(null);
        if(noticeService==null){
            log.warn("noticeService not found");
            return null;
        }
        return noticeService.sendNotice(comment);
    }


}
