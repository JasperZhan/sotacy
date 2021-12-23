package cn.hzu.sotacy.model.user;

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
@TableName("learning_status")
@ApiModel(value = "LearningStatus对象", description = "")
public class LearningStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("学习状态表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("课程id                        ")
    @TableField("course_id")
    private Integer courseId;

    @ApiModelProperty("单元id")
    @TableField("course_unit_id")
    private Integer courseUnitId;

    @ApiModelProperty("视频学习状态（0: 未看完, 1: 已看完）")
    @TableField("vedio_status")
    private String vedioStatus;

    @ApiModelProperty("视频学习进度")
    @TableField("vedio_rate")
    private Float vedioRate;

    @ApiModelProperty("测试完成状态（0: 未测试, 1: 已测试）")
    @TableField("test_status")
    private String testStatus;

    @ApiModelProperty("测试得分")
    @TableField("test_score")
    private Float testScore;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
