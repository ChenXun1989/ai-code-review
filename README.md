# ai-code-review
Ai for code review

# 使用手册
### 下载代码
> git clone https://github.com/ChenXun1989/ai-code-review.git

### 安装依赖
> mvn install -DSkipTests

### 配置文件设置
| 名称            | 属性key                                | 是否必填 | 默认值                      |
|---------------|--------------------------------------|------|--------------------------|
| 企业微信机器人hook地址 | ai-code-review.weChat.hookUrl        | 否    | 无                        |
| 大语言模型类型       | ai-code-review.llmType               | 是    | deepseek                 |
| DeepSeek主机地址  | ai-code-review.deepseek.host         | 是    | https://api.deepseek.com |
| DeepSeek密钥    | ai-code-review.deepseek.token        | 是    | 无                        |
| GitLab密钥      | ai-code-review.gitlab.token          | 是    | 无                        |
| GitLab主机地址    | ai-code-review.gitlab.host           | 是    | 无                        |
| 文件后缀          | ai-code-review.gitlab.fileExtensions | 是    | .java                    |
| 服务端口          | server.port                          | 是    | 9500                     |


### 运行启动类
> wiki.chenxun.ai.code.review.boot.Application

### 配置gitlab webhook
> http:{host}:{port}/gitlab/merge/event

# 设计思路

# 联系方式

## 个人博客
[https://www.chenxun.wiki](https://www.chenxun.wiki)

