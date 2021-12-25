package cn.hzu.sotacy.model.blankQuestion;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
@TableName("blank_question")
@ApiModel(value = "BlankQuestion对象", description = "")
public class BlankQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("填空题id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("填空题题目")
    @TableField("subject")
    private String subject;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private List<BlankQuestionItem> blankQuestionItemList;

    @TableField(exist = false)
    private Integer courseUnitId;

    @Override
    public String toString() {
        StringBuilder a = new StringBuilder("------------------------------------\n" +
                "blankQuestion = {\n" +
                "id = '" + id + "'\n" +
                "subject = '" + subject + "'\n" +
                "create_time = '" + createTime + "'\n" +
                "update_time = '" + updateTime + "'\n");
        for (BlankQuestionItem blankQuestionItem: blankQuestionItemList) {
            a.append(blankQuestionItem.toString());
        }
        a.append("}\n" + "------------------------------------");
        return a.toString();
    }
}
