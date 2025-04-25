package wiki.chenxun.ai.code.review.core.model;

import lombok.Data;

/**
 * @author: chenxun
 * @date: 2025/4/24
 * @version: 1.0
 * @desc
 **/
@Data
public class PromptMessage {


    private String role ="user";

    private String content;



}
