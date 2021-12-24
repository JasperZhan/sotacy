package cn.hzu.sotacy.model.choiceQuestion;

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
 * @since 2021-12-23
 */
@Getter
@Setter
@TableName("choice_question_option")
@ApiModel(value = "ChoiceQuestionOption对象", description = "")
public class ChoiceQuestionOption implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("选择题选项id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("选项内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("选项所属问题id")
    @TableField("choice_question_id")
    private Integer choiceQuestionId;


}
