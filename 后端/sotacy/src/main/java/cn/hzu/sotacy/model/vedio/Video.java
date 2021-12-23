package cn.hzu.sotacy.model.vedio;

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
@TableName("video")
@ApiModel(value = "Video对象", description = "")
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("视频id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("视频所属单元id")
    @TableField("course_unit_id")
    private Integer courseUnitId;

    @ApiModelProperty("视频地址")
    @TableField("url")
    private String url;

    @ApiModelProperty("视频名字")
    @TableField("name")
    private String name;

    @ApiModelProperty("视频描述")
    @TableField("describe")
    private String describe;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
