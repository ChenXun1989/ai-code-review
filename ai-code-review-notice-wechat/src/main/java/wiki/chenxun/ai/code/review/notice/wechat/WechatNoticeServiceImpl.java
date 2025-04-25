package wiki.chenxun.ai.code.review.notice.wechat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import wiki.chenxun.ai.code.review.core.config.Config;
import wiki.chenxun.ai.code.review.core.service.NoticeService;

/**
 * @author: chenxun
 * @date: 2025/4/25
 * @version: 1.0
 * @desc
 **/
@Slf4j
@Component
public class WechatNoticeServiceImpl implements NoticeService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Config config;
    @Override
    public String sendNotice(String notice) {

        WechatMessageReq wechatMessageReq = new WechatMessageReq();
        wechatMessageReq.setMarkdown(notice);
        log.info("企业微信群机器人推送消息参数:{}", wechatMessageReq);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(wechatMessageReq.toString(), headers);

        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(
                config.getWeChat().getHookUrl(), httpEntity, String.class);
        log.info("企业微信群机器人推送消息返回:{}", stringResponseEntity);
        return stringResponseEntity.getBody();
    }

    @Override
    public String code() {
        return "wechat";
    }
}
