package wiki.chenxun.ai.code.review.boot.controller.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: chenxun
 * @date: 2025/4/24
 * @version: 1.0
 * @desc
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GitLabMergeContentRes {


    private String  diff;

    @JsonProperty("new_path")
    private String newPath;

    @JsonProperty("deleted_file")
    private boolean deletedFile;

    @JsonProperty("new_file")
    private boolean newFile;
}
