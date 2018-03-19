package kz.gala.testing.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ExamPrimaryKey implements Serializable { // обязательно должно быть
    @Column(name = "user_id")
    @NotBlank
    private Integer  userId;

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

    public Integer getQuestionId() {
        return questionId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamPrimaryKey that = (ExamPrimaryKey) o;

        if (!userId.equals(that.userId)) return false;
        return questionId.equals(that.questionId);

    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + questionId.hashCode();
        return result;
    }
}
