package cn.hzu.sotacy.model.judgmentQuestion;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
@Getter
@Setter
@TableName("judgment_question")
@ApiModel(value = "JudgmentQuestion对象", description = "")
public class JudgmentQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("判断题id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("判断题题目")
    @TableField("subject")
    private String subject;

    @ApiModelProperty("判断题答案（0：错， 1：对）")
    @TableField("answer")
    private String answer;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
