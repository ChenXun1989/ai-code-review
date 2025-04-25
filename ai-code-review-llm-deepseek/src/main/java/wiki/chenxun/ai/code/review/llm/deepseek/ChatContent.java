package wiki.chenxun.ai.code.review.llm.deepseek;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wiki.chenxun.ai.code.review.core.model.PromptMessage;

import java.util.List;

/**
 * @author: chenxun
 * @date: 2025/4/24
 * @version: 1.0
 * @desc
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatContent {

    private String model ="deepseek-chat";
    @JsonProperty("frequency_penalty")
    private int frequencyPenalty =0;

    @JsonProperty("max_tokens")
    private int maxTokens =4096;

    @JsonProperty("presence_penalty")
    private int presencePenalty = 0;
    @JsonProperty("response_format")
    private ResponseFormat responseFormat =new ResponseFormat("text");
    private String stop;
    private String stream;
    @JsonProperty("stream_options")
    private String streamOptions;
    private int temperature = 1;
    @JsonProperty("top_p")
    private int topP =1;
    private String tools;
    @JsonProperty("tool_choice")
    private String toolChoice;
    private boolean logprobs;
    private List<PromptMessage> messages;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ResponseFormat{

        private String type;
    }
}
