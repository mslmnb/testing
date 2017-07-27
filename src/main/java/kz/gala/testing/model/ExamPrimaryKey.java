package kz.gala.testing.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamPrimaryKey that = (ExamPrimaryKey) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return questionId != null ? questionId.equals(that.questionId) : that.questionId == null;

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        return result;
    }
}
