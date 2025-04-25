package wiki.chenxun.ai.code.review.boot.controller.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "Gitlab Merge Request Event")
public class GitlabMergeRequestEvent {
    @JsonProperty("object_kind")
    @Schema(description = "对象种类", example = "merge_request")
    private String objectKind;

    @JsonProperty("event_type")
    @Schema(description =  "事件类型", example = "merge_request")
    private String eventType;

    @Schema(description =  "用户信息")
    private User user;

    @Schema(description =  "项目信息")
    private Project project;

    @JsonProperty("object_attributes")
    @Schema(description =  "对象属性")
    private ObjectAttributes objectAttributes;

    @Schema(description =  "标签列表")
    private List<Label> labels;

    @Schema(description =  "更改信息")
    private Changes changes;

    @Schema(description =  "仓库信息")
    private Repository repository;

    @Schema(description =  "分配人列表")
    private List<Assignee> assignees;

    @Schema(description =  "审查人列表")
    private List<Reviewer> reviewers;

    @Data
    @NoArgsConstructor
    @Schema(description = "用户信息")
    public static class User {
        @Schema(description =  "用户ID", example = "759")
        private int id;

        @Schema(description =  "用户名", example = "陈勋")
        private String name;

        @Schema(description =  "用户名字", example = "10020598")
        private String username;

        @Schema(description =  "头像URL", example = "null")
        private String avatarUrl;

        @Schema(description =  "用户邮箱", example = "[REDACTED]")
        private String email;
    }

    @Data
    @NoArgsConstructor
    @Schema(description = "项目信息")
    public static class Project {
        @Schema(description =  "项目ID", example = "3748")
        private int id;

        @Schema(description =  "项目名称", example = "lbx-mps-polaris")
        private String name;

        @Schema(description =  "项目描述", example = "null")
        private String description;

        @Schema(description =  "项目Web URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris")
        private String webUrl;

        @Schema(description =  "项目头像URL", example = "null")
        private String avatarUrl;

        @Schema(description =  "项目SSH URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String gitSshUrl;

        @Schema(description =  "项目HTTP URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris.git")
        private String gitHttpUrl;

        @Schema(description =  "项目命名空间", example = "marketing-platform")
        private String namespace;

        @Schema(description =  "可见性级别", example = "0")
        private int visibilityLevel;

        @Schema(description =  "项目路径命名空间", example = "supply/marketing-platform/lbx-mps-polaris")
        private String pathWithNamespace;

        @Schema(description =  "默认分支", example = "master")
        private String defaultBranch;

        @Schema(description =  "CI配置路径", example = "")
        private String ciConfigPath;

        @Schema(description =  "项目主页", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris")
        private String homepage;

        @Schema(description =  "项目URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String url;

        @Schema(description =  "项目SSH URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String sshUrl;

        @Schema(description =  "项目HTTP URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris.git")
        private String httpUrl;
    }

    @Data
    @NoArgsConstructor
    @Schema(description = "对象属性")
    public static class ObjectAttributes {
        @Schema(description =  "分配人ID", example = "759")
        private int assigneeId;

        @Schema(description =  "作者ID", example = "759")
        private int authorId;

        @Schema(description =  "创建时间", example = "2025-04-24 09:10:00 UTC")
        private String createdAt;

        @Schema(description =  "描述", example = "在购物车计算中增加了满金额折扣的计算类型，以支持新的营销活动。")
        private String description;

        @Schema(description =  "头部流水线ID", example = "null")
        private Integer headPipelineId;

        @Schema(description =  "ID", example = "57274")
        private int id;

        @Schema(description =  "IID", example = "133")
        private int iid;

        @Schema(description =  "最后编辑时间", example = "null")
        private String lastEditedAt;

        @Schema(description =  "最后编辑人ID", example = "null")
        private Integer lastEditedById;

        @Schema(description =  "合并提交SHA", example = "null")
        private String mergeCommitSha;

        @Schema(description =  "合并错误", example = "null")
        private String mergeError;

        @Schema(description =  "合并参数")
        private MergeParams mergeParams;

        @Schema(description =  "合并状态", example = "preparing")
        private String mergeStatus;

        @Schema(description =  "合并用户ID", example = "null")
        private Integer mergeUserId;

        @Schema(description =  "合并时管道成功", example = "false")
        private boolean mergeWhenPipelineSucceeds;

        @Schema(description =  "里程碑ID", example = "null")
        private Integer milestoneId;

        @Schema(description =  "源分支", example = "feature/init-cx")
        private String sourceBranch;

        @Schema(description =  "源项目ID", example = "3748")
        private int sourceProjectId;

        @Schema(description =  "状态ID", example = "1")
        private int stateId;

        @Schema(description =  "目标分支", example = "release")
        private String targetBranch;

        @Schema(description =  "目标项目ID", example = "3748")
        private int targetProjectId;

        @Schema(description =  "时间估计", example = "0")
        private int timeEstimate;

        @Schema(description =  "标题", example = "feat(calc): 添加满减折扣类型")
        private String title;

        @Schema(description =  "更新时间", example = "2025-04-24 09:10:00 UTC")
        private String updatedAt;

        @Schema(description =  "更新人ID", example = "null")
        private Integer updatedById;

        @Schema(description =  "URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris/-/merge_requests/133")
        private String url;

        @Schema(description =  "源信息")
        private Source source;

        @Schema(description =  "目标信息")
        private Target target;

        @Schema(description =  "最后提交")
        private LastCommit lastCommit;

        @Schema(description =  "工作进行中", example = "false")
        private boolean workInProgress;

        @Schema(description =  "总花费时间", example = "0")
        private int totalTimeSpent;

        @Schema(description =  "时间变化", example = "0")
        private int timeChange;

        @Schema(description =  "人类总花费时间", example = "null")
        private String humanTotalTimeSpent;

        @Schema(description =  "人类时间变化", example = "null")
        private String humanTimeChange;

        @Schema(description =  "人类时间估计", example = "null")
        private String humanTimeEstimate;

        @Schema(description =  "分配人ID列表")
        private List<Integer> assigneeIds;

        @Schema(description =  "审查人ID列表")
        private List<Integer> reviewerIds;

        @Schema(description =  "标签列表")
        private List<Label> labels;

        @Schema(description =  "状态", example = "opened")
        private String state;

        @Schema(description =  "阻止讨论已解决", example = "true")
        private boolean blockingDiscussionsResolved;

        @Schema(description =  "首次贡献", example = "false")
        private boolean firstContribution;

        @Schema(description =  "详细合并状态", example = "mergeable")
        private String detailedMergeStatus;

        @Schema(description =  "操作", example = "open")
        private String action;
    }

    @Data
    @NoArgsConstructor
    @Schema(description = "合并参数")
    public static class MergeParams {
        @JsonProperty("force_remove_source_branch")
        @Schema(description =  "强制移除源分支", example = "0")
        private String forceRemoveSourceBranch;
    }

    @Data
    @NoArgsConstructor
    @Schema(description = "源信息")
    public static class Source {
        @Schema(description =  "ID", example = "3748")
        private int id;

        @Schema(description =  "名称", example = "lbx-mps-polaris")
        private String name;

        @Schema(description =  "描述", example = "null")
        private String description;

        @Schema(description =  "Web URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris")
        private String webUrl;

        @Schema(description =  "头像URL", example = "null")
        private String avatarUrl;

        @Schema(description =  "SSH URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String gitSshUrl;

        @Schema(description =  "HTTP URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris.git")
        private String gitHttpUrl;

        @Schema(description =  "命名空间", example = "marketing-platform")
        private String namespace;

        @Schema(description =  "可见性级别", example = "0")
        private int visibilityLevel;

        @Schema(description =  "路径命名空间", example = "supply/marketing-platform/lbx-mps-polaris")
        private String pathWithNamespace;

        @Schema(description =  "默认分支", example = "master")
        private String defaultBranch;

        @Schema(description =  "CI配置路径", example = "")
        private String ciConfigPath;

        @Schema(description =  "主页", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris")
        private String homepage;

        @Schema(description =  "URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String url;

        @Schema(description =  "SSH URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String sshUrl;

        @Schema(description =  "HTTP URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris.git")
        private String httpUrl;
    }

    @Data
    @NoArgsConstructor
    @Schema(description = "目标信息")
    public static class Target {
        @Schema(description =  "ID", example = "3748")
        private int id;

        @Schema(description =  "名称", example = "lbx-mps-polaris")
        private String name;

        @Schema(description =  "描述", example = "null")
        private String description;

        @Schema(description =  "Web URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris")
        private String webUrl;

        @Schema(description =  "头像URL", example = "null")
        private String avatarUrl;

        @Schema(description =  "SSH URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String gitSshUrl;

        @Schema(description =  "HTTP URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris.git")
        private String gitHttpUrl;

        @Schema(description =  "命名空间", example = "marketing-platform")
        private String namespace;

        @Schema(description =  "可见性级别", example = "0")
        private int visibilityLevel;

        @Schema(description =  "路径命名空间", example = "supply/marketing-platform/lbx-mps-polaris")
        private String pathWithNamespace;

        @Schema(description =  "默认分支", example = "master")
        private String defaultBranch;

        @Schema(description =  "CI配置路径", example = "")
        private String ciConfigPath;

        @Schema(description =  "主页", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris")
        private String homepage;

        @Schema(description =  "URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String url;

        @Schema(description =  "SSH URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String sshUrl;

        @Schema(description =  "HTTP URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris.git")
        private String httpUrl;
    }

    @Data
    @NoArgsConstructor
    @Schema(description = "最后提交")
    public static class LastCommit {
        @Schema(description =  "ID", example = "4a599bcc06459a547acfe313c82a35e90297f458")
        private String id;

        @Schema(description =  "消息", example = "fix(lbx-mps-polaris-core): 修复营销元数据比较逻辑空指针异常\n\n- 在 MarketingMeta 类的 equalsWithCodeAndRuleLine 方法中添加了对传入参数的空值检查\n- 避免了当传入的 meta 对象为 null 时，访问其属性导致的空指针异常\n")
        private String message;

        @Schema(description =  "标题", example = "fix(lbx-mps-polaris-core): 修复营销元数据比较逻辑空指针异常")
        private String title;

        @Schema(description =  "时间戳", example = "2025-04-24T15:40:31+08:00")
        private String timestamp;

        @Schema(description =  "URL", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris/-/commit/4a599bcc06459a547acfe313c82a35e90297f458")
        private String url;

        @Schema(description =  "作者")
        private Author author;
    }

    @Data
    @NoArgsConstructor
    @Schema(description = "作者")
    public static class Author {
        @Schema(description =  "名字", example = "chenxun")
        private String name;

        @Schema(description =  "邮箱", example = "[REDACTED]")
        private String email;
    }

    @Data
    @NoArgsConstructor
    @Schema(description = "更改信息")
    public static class Changes {
        // Define changes fields as needed
    }

    @Data
    @NoArgsConstructor
    @Schema(description = "仓库信息")
    public static class Repository {
        @Schema(description =  "名称", example = "lbx-mps-polaris")
        private String name;

        @Schema(description =  "URL", example = "git@gitlab.lbxdrugs.com:supply/marketing-platform/lbx-mps-polaris.git")
        private String url;

        @Schema(description =  "描述", example = "null")
        private String description;

        @Schema(description =  "主页", example = "https://gitlab.lbxdrugs.com/supply/marketing-platform/lbx-mps-polaris")
        private String homepage;
    }

    @Data
    @NoArgsConstructor
    @Schema(description = "接收人")
    public static class Assignee {
        @Schema(description =  "ID", example = "1")
        private int id;
        @Schema(description =  "名字")
        private String name;
        @Schema(description =  "用户名")
        private String username;
        @Schema(description =  "头像URL")
        private String avatarUrl;
        @Schema(description =  "邮箱")
        private String email;
    }

    @Data
    @NoArgsConstructor
    @Schema(description = "审核人")
    public static class Reviewer {
        @Schema(description =  "ID", example = "1")
        private int id;
        @Schema(description =  "名字")
        private String name;
        @Schema(description =  "用户名")
        private String username;
        @Schema(description =  "头像URL")
        private String avatarUrl;
        @Schema(description =  "邮箱")
        private String email;
    }

    @Data
    @NoArgsConstructor
    public static class Label {
        // Define label fields as needed
    }
}
