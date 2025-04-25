package wiki.chenxun.ai.code.review.notice.wechat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: chenxun
 * @date: 2025/4/25
 * @version: 1.0
 * @desc
 **/
@Data
public class WechatMessageReq {

    @JsonProperty("msgtype")
    private String msgType ="markdown";
    private String markdown;
}
