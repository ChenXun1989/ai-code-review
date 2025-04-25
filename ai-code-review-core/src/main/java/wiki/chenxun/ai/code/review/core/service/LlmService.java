package wiki.chenxun.ai.code.review.core.service;

import wiki.chenxun.ai.code.review.core.model.PromptMessage;

import java.util.List;

/**
 * @author: chenxun
 * @date: 2025/4/24
 * @version: 1.0
 * @desc
 **/
public interface LlmService extends Router {

    String sendPrompt(List<PromptMessage> promptMessages);
}
