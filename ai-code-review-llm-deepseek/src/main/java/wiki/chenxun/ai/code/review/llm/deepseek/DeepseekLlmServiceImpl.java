package wiki.chenxun.ai.code.review.llm.deepseek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import wiki.chenxun.ai.code.review.core.config.Config;
import wiki.chenxun.ai.code.review.core.model.PromptMessage;
import wiki.chenxun.ai.code.review.core.service.LlmService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: chenxun
 * @date: 2025/4/24
 * @version: 1.0
 * @desc
 **/
@Component
public class DeepseekLlmServiceImpl implements LlmService {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Config config;

    @Override
    public String sendPrompt(List<PromptMessage> promptMessages) {


        ChatContent content = new ChatContent();
        content.setMessages(promptMessages);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", config.getDeepseek().getToken());
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");
        HttpEntity<?> entity = new HttpEntity<>(content, headers);
        String url=config.getDeepseek().getHost()+"/chat/completions";

        ResponseEntity<ChatCompletionResponse> res= restTemplate.postForEntity(url,entity, ChatCompletionResponse.class);

        return res.getBody().getChoices().stream()
                .map(i->i.getMessage().getContent()).collect(Collectors.joining("\t\n"));



    }


    @Override
    public String code() {
        return "deepseek";
    }
}
