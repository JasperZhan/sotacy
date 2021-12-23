package cn.hzu.sotacy.model.course;

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
@TableName("course_unit")
@ApiModel(value = "CourseUnit对象", description = "")
public class CourseUnit implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("课程单元id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("课程单元次序 (1,2,3...)")
    @TableField("order")
    private Integer order;

    @ApiModelProperty("课程单元标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("课程单元描述")
    @TableField("describe")
    private String describe;

    @ApiModelProperty("单元所属课程id")
    @TableField("course_id")
    private Integer courseId;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
