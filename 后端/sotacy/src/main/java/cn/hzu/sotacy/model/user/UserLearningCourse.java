package cn.hzu.sotacy.model.user;

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
@TableName("user_learning_course")
@ApiModel(value = "UserLearningCourse对象", description = "")
public class UserLearningCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户学习课程id")
    @TableId("id")
    private Integer id;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("课程id")
    @TableField("course_id")
    private Integer courseId;

    @ApiModelProperty("学习状态（0：学习中， 1：学习完）")
    @TableField("learning_state")
    private String learningState;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
