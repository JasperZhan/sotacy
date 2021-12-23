package cn.hzu.sotacy.model.certificate;

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
@TableName("certificate")
@ApiModel(value = "Certificate对象", description = "")
public class Certificate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("证书id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("证书名字")
    @TableField("name")
    private String name;

    @ApiModelProperty("证书描述")
    @TableField("describe")
    private String describe;

    @ApiModelProperty("证书图标")
    @TableField("icon_url")
    private String iconUrl;

    @ApiModelProperty("证书id")
    @TableField("course_id")
    private Integer courseId;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
