package kz.gala.testing.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * WARN  RootClass [RootClass.java:285] HHH000038: Composite-id class does not override equals(): kz.gala.testing.model.ExamPrimaryKey
 WARN  RootClass [RootClass.java:288] HHH000039: Composite-id class does not override hashCode(): kz.gala.testing.model.ExamPrimaryKey
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
