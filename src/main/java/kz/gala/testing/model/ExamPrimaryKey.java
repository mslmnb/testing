package kz.gala.testing.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Mussulmanbekova_GE on 20.06.2017.
 */
@Embeddable
public class ExamPrimaryKey implements Serializable {

    @Column(name = "user_id")
    @NotBlank
    private Integer userId;

    @Column(name = "question_id", nullable = false)
    @NotBlank
    private Integer questionId;

    public ExamPrimaryKey() {
    }

    public ExamPrimaryKey(Integer userId, Integer questionId) {
        this.userId = userId;
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}
