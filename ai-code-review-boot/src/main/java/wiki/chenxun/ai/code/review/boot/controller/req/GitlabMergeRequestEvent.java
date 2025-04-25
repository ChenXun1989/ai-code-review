package wiki.chenxun.ai.code.review.boot.controller.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@ApiModel(description = "Gitlab Merge Request Event")
public class GitlabMergeRequestEvent {
    @JsonProperty("object_kind")
    @ApiModelProperty(value = "对象种类", example = "merge_request")
    private String objectKind;

    @JsonProperty("event_type")
    @ApiModelProperty(value = "事件类型", example = "merge_request")
    private String eventType;

    @ApiModelProperty(value = "用户信息")
    private User user;

    @ApiModelProperty(value = "项目信息")
    private Project project;

    @JsonProperty("object_attributes")
    @ApiModelProperty(value = "对象属性")
    private ObjectAttributes objectAttributes;

    @ApiModelProperty(value = "标签列表")
    private List<Label> labels;

    @ApiModelProperty(value = "更改信息")
    private Changes changes;

    @ApiModelProperty(value = "仓库信息")
    private Repository repository;

    @ApiModelProperty(value = "分配人列表")
    private List<Assignee> assignees;

    @ApiModelProperty(value = "审查人列表")
    private List<Reviewer> reviewers;

    @Data
    @NoArgsConstructor
    @ApiModel(description = "用户信息")
    public static class User {
        @ApiModelProperty(value = "用户ID", example = "759")
        private int id;

        @ApiModelProperty(value = "用户名", example = "陈勋")
        private String name;

        @ApiModelProperty(value = "用户名字", example = "10020598")
        private String username;

        @ApiModelProperty(value = "头像URL", example = "null")
        private String avatarUrl;

        @ApiModelProperty(value = "用户邮箱", example = "[REDACTED]")
        private String email;
    }

    @Data
    @NoArgsConstructor
    @ApiModel(description = "项目信息")
    public static class Project {
        @ApiModelProperty(value = "项目ID", example = "3748")
        private int id;

        @ApiModelProperty(value = "项目名称", example = "lbx-mps-polaris")
        private String name;

        @ApiModelProperty(value = "项目描述", example = "null")
        private String description;

        @ApiModelProperty(value = "项目Web URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris")
        private String webUrl;

        @ApiModelProperty(value = "项目头像URL", example = "null")
        private String avatarUrl;

        @ApiModelProperty(value = "项目SSH URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String gitSshUrl;

        @ApiModelProperty(value = "项目HTTP URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris.git")
        private String gitHttpUrl;

        @ApiModelProperty(value = "项目命名空间", example = "marketing-platform")
        private String namespace;

        @ApiModelProperty(value = "可见性级别", example = "0")
        private int visibilityLevel;

        @ApiModelProperty(value = "项目路径命名空间", example = "supply/marketing-platform/lbx-mps-polaris")
        private String pathWithNamespace;

        @ApiModelProperty(value = "默认分支", example = "master")
        private String defaultBranch;

        @ApiModelProperty(value = "CI配置路径", example = "")
        private String ciConfigPath;

        @ApiModelProperty(value = "项目主页", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris")
        private String homepage;

        @ApiModelProperty(value = "项目URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String url;

        @ApiModelProperty(value = "项目SSH URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String sshUrl;

        @ApiModelProperty(value = "项目HTTP URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris.git")
        private String httpUrl;
    }

    @Data
    @NoArgsConstructor
    @ApiModel(description = "对象属性")
    public static class ObjectAttributes {
        @ApiModelProperty(value = "分配人ID", example = "759")
        private int assigneeId;

        @ApiModelProperty(value = "作者ID", example = "759")
        private int authorId;

        @ApiModelProperty(value = "创建时间", example = "2025-04-24 09:10:00 UTC")
        private String createdAt;

        @ApiModelProperty(value = "描述", example = "在购物车计算中增加了满金额折扣的计算类型，以支持新的营销活动。")
        private String description;

        @ApiModelProperty(value = "头部流水线ID", example = "null")
        private Integer headPipelineId;

        @ApiModelProperty(value = "ID", example = "57274")
        private int id;

        @ApiModelProperty(value = "IID", example = "133")
        private int iid;

        @ApiModelProperty(value = "最后编辑时间", example = "null")
        private String lastEditedAt;

        @ApiModelProperty(value = "最后编辑人ID", example = "null")
        private Integer lastEditedById;

        @ApiModelProperty(value = "合并提交SHA", example = "null")
        private String mergeCommitSha;

        @ApiModelProperty(value = "合并错误", example = "null")
        private String mergeError;

        @ApiModelProperty(value = "合并参数")
        private MergeParams mergeParams;

        @ApiModelProperty(value = "合并状态", example = "preparing")
        private String mergeStatus;

        @ApiModelProperty(value = "合并用户ID", example = "null")
        private Integer mergeUserId;

        @ApiModelProperty(value = "合并时管道成功", example = "false")
        private boolean mergeWhenPipelineSucceeds;

        @ApiModelProperty(value = "里程碑ID", example = "null")
        private Integer milestoneId;

        @ApiModelProperty(value = "源分支", example = "feature/init-cx")
        private String sourceBranch;

        @ApiModelProperty(value = "源项目ID", example = "3748")
        private int sourceProjectId;

        @ApiModelProperty(value = "状态ID", example = "1")
        private int stateId;

        @ApiModelProperty(value = "目标分支", example = "release")
        private String targetBranch;

        @ApiModelProperty(value = "目标项目ID", example = "3748")
        private int targetProjectId;

        @ApiModelProperty(value = "时间估计", example = "0")
        private int timeEstimate;

        @ApiModelProperty(value = "标题", example = "feat(calc): 添加满减折扣类型")
        private String title;

        @ApiModelProperty(value = "更新时间", example = "2025-04-24 09:10:00 UTC")
        private String updatedAt;

        @ApiModelProperty(value = "更新人ID", example = "null")
        private Integer updatedById;

        @ApiModelProperty(value = "URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris/-/merge_requests/133")
        private String url;

        @ApiModelProperty(value = "源信息")
        private Source source;

        @ApiModelProperty(value = "目标信息")
        private Target target;

        @ApiModelProperty(value = "最后提交")
        private LastCommit lastCommit;

        @ApiModelProperty(value = "工作进行中", example = "false")
        private boolean workInProgress;

        @ApiModelProperty(value = "总花费时间", example = "0")
        private int totalTimeSpent;

        @ApiModelProperty(value = "时间变化", example = "0")
        private int timeChange;

        @ApiModelProperty(value = "人类总花费时间", example = "null")
        private String humanTotalTimeSpent;

        @ApiModelProperty(value = "人类时间变化", example = "null")
        private String humanTimeChange;

        @ApiModelProperty(value = "人类时间估计", example = "null")
        private String humanTimeEstimate;

        @ApiModelProperty(value = "分配人ID列表")
        private List<Integer> assigneeIds;

        @ApiModelProperty(value = "审查人ID列表")
        private List<Integer> reviewerIds;

        @ApiModelProperty(value = "标签列表")
        private List<Label> labels;

        @ApiModelProperty(value = "状态", example = "opened")
        private String state;

        @ApiModelProperty(value = "阻止讨论已解决", example = "true")
        private boolean blockingDiscussionsResolved;

        @ApiModelProperty(value = "首次贡献", example = "false")
        private boolean firstContribution;

        @ApiModelProperty(value = "详细合并状态", example = "mergeable")
        private String detailedMergeStatus;

        @ApiModelProperty(value = "操作", example = "open")
        private String action;
    }

    @Data
    @NoArgsConstructor
    @ApiModel(description = "合并参数")
    public static class MergeParams {
        @JsonProperty("force_remove_source_branch")
        @ApiModelProperty(value = "强制移除源分支", example = "0")
        private String forceRemoveSourceBranch;
    }

    @Data
    @NoArgsConstructor
    @ApiModel(description = "源信息")
    public static class Source {
        @ApiModelProperty(value = "ID", example = "3748")
        private int id;

        @ApiModelProperty(value = "名称", example = "lbx-mps-polaris")
        private String name;

        @ApiModelProperty(value = "描述", example = "null")
        private String description;

        @ApiModelProperty(value = "Web URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris")
        private String webUrl;

        @ApiModelProperty(value = "头像URL", example = "null")
        private String avatarUrl;

        @ApiModelProperty(value = "SSH URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String gitSshUrl;

        @ApiModelProperty(value = "HTTP URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris.git")
        private String gitHttpUrl;

        @ApiModelProperty(value = "命名空间", example = "marketing-platform")
        private String namespace;

        @ApiModelProperty(value = "可见性级别", example = "0")
        private int visibilityLevel;

        @ApiModelProperty(value = "路径命名空间", example = "supply/marketing-platform/lbx-mps-polaris")
        private String pathWithNamespace;

        @ApiModelProperty(value = "默认分支", example = "master")
        private String defaultBranch;

        @ApiModelProperty(value = "CI配置路径", example = "")
        private String ciConfigPath;

        @ApiModelProperty(value = "主页", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris")
        private String homepage;

        @ApiModelProperty(value = "URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String url;

        @ApiModelProperty(value = "SSH URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String sshUrl;

        @ApiModelProperty(value = "HTTP URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris.git")
        private String httpUrl;
    }

    @Data
    @NoArgsConstructor
    @ApiModel(description = "目标信息")
    public static class Target {
        @ApiModelProperty(value = "ID", example = "3748")
        private int id;

        @ApiModelProperty(value = "名称", example = "lbx-mps-polaris")
        private String name;

        @ApiModelProperty(value = "描述", example = "null")
        private String description;

        @ApiModelProperty(value = "Web URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris")
        private String webUrl;

        @ApiModelProperty(value = "头像URL", example = "null")
        private String avatarUrl;

        @ApiModelProperty(value = "SSH URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String gitSshUrl;

        @ApiModelProperty(value = "HTTP URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris.git")
        private String gitHttpUrl;

        @ApiModelProperty(value = "命名空间", example = "marketing-platform")
        private String namespace;

        @ApiModelProperty(value = "可见性级别", example = "0")
        private int visibilityLevel;

        @ApiModelProperty(value = "路径命名空间", example = "supply/marketing-platform/lbx-mps-polaris")
        private String pathWithNamespace;

        @ApiModelProperty(value = "默认分支", example = "master")
        private String defaultBranch;

        @ApiModelProperty(value = "CI配置路径", example = "")
        private String ciConfigPath;

        @ApiModelProperty(value = "主页", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris")
        private String homepage;

        @ApiModelProperty(value = "URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String url;

        @ApiModelProperty(value = "SSH URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String sshUrl;

        @ApiModelProperty(value = "HTTP URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris.git")
        private String httpUrl;
    }

    @Data
    @NoArgsConstructor
    @ApiModel(description = "最后提交")
    public static class LastCommit {
        @ApiModelProperty(value = "ID", example = "4a599bcc06459a547acfe313c82a35e90297f458")
        private String id;

        @ApiModelProperty(value = "消息", example = "fix(lbx-mps-polaris-core): 修复营销元数据比较逻辑空指针异常\n\n- 在 MarketingMeta 类的 equalsWithCodeAndRuleLine 方法中添加了对传入参数的空值检查\n- 避免了当传入的 meta 对象为 null 时，访问其属性导致的空指针异常\n")
        private String message;

        @ApiModelProperty(value = "标题", example = "fix(lbx-mps-polaris-core): 修复营销元数据比较逻辑空指针异常")
        private String title;

        @ApiModelProperty(value = "时间戳", example = "2025-04-24T15:40:31+08:00")
        private String timestamp;

        @ApiModelProperty(value = "URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris/-/commit/4a599bcc06459a547acfe313c82a35e90297f458")
        private String url;

        @ApiModelProperty(value = "作者")
        private Author author;
    }

    @Data
    @NoArgsConstructor
    @ApiModel(description = "作者")
    public static class Author {
        @ApiModelProperty(value = "名字", example = "chenxun")
        private String name;

        @ApiModelProperty(value = "邮箱", example = "[REDACTED]")
        private String email;
    }

    @Data
    @NoArgsConstructor
    @ApiModel(description = "更改信息")
    public static class Changes {
        // Define changes fields as needed
    }

    @Data
    @NoArgsConstructor
    @ApiModel(description = "仓库信息")
    public static class Repository {
        @ApiModelProperty(value = "名称", example = "lbx-mps-polaris")
        private String name;

        @ApiModelProperty(value = "URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String url;

        @ApiModelProperty(value = "描述", example = "null")
        private String description;

        @ApiModelProperty(value = "主页", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris")
        private String homepage;
    }

    @Data
    @NoArgsConstructor
    @ApiModel(description = "接收人")
    public static class Assignee {
        @ApiModelProperty(value = "ID", example = "1")
        private int id;
        @ApiModelProperty(value = "名字")
        private String name;
        @ApiModelProperty(value = "用户名")
        private String username;
        @ApiModelProperty(value = "头像URL")
        private String avatarUrl;
        @ApiModelProperty(value = "邮箱")
        private String email;
    }

    @Data
    @NoArgsConstructor
    @ApiModel(description = "审核人")
    public static class Reviewer {
        @ApiModelProperty(value = "ID", example = "1")
        private int id;
        @ApiModelProperty(value = "名字")
        private String name;
        @ApiModelProperty(value = "用户名")
        private String username;
        @ApiModelProperty(value = "头像URL")
        private String avatarUrl;
        @ApiModelProperty(value = "邮箱")
        private String email;
    }

    @Data
    @NoArgsConstructor
    public static class Label {
        // Define label fields as needed
    }
}
