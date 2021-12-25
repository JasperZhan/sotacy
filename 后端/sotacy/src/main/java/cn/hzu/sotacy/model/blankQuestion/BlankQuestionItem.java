package cn.hzu.sotacy.model.blankQuestion;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
 * @since 2021-12-25
 */
@Getter
@Setter
@TableName("blank_question_item")
@ApiModel(value = "BlankQuestionItem对象", description = "")
public class BlankQuestionItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("填空题答案项id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("填空题答案项次序（1,2,3...）")
    @TableField("order")
    private Integer order;

    @ApiModelProperty("填空题答案")
    @TableField("content")
    private String content;

    @ApiModelProperty("填空题答案")
    @TableField("blank_question_id")
    private Integer blankQuestionId;

    @Override
    public String toString() {
        return "------------------------------------\n" +
                "BlankQuestionItem = {\n" +
                "id = '" + id + "'\n" +
                "order = '" + order + "'\n" +
                "content = '" + content + "'\n" +
                "blankQuestionId = '" + blankQuestionId + "'\n" +
                "}\n" +
                "------------------------------------\n";
    }
}
