package wiki.chenxun.ai.code.review.core.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author: chenxun
 * @date: 2025/4/24
 * @version: 1.0
 * @desc
 **/
@Configuration
@ConfigurationProperties(prefix = "ai-code-review")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Config {

    @NotNull
    private PromptTemplate promptTemplate;

    @NotNull
    private Gitlab gitlab;

    @NotNull
    private String llmType;

    private String noticeType;


    private Deepseek deepseek;

    private WeChat weChat;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Gitlab{
        private String token;
        private String host;
        private List<String> fileExtensions;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PromptTemplate {
        /**
         * 头部
         */
        @NotNull
        private String header;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Deepseek{

        private String host;

        private String token;
    }

    @Data
    public static class WeChat{

        private String hookUrl;


    }

}
