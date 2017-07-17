package kz.gala.testing.to;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class QuestionWithUserAnswer implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer questionId;
    private Integer userAnswerId;
    private Integer userOldAnswerId;

    public QuestionWithUserAnswer() {
    }

    public QuestionWithUserAnswer(Integer questionId, Integer userAnswerId, Integer userOldAnswerId) {
        this.questionId = questionId;
        this.userAnswerId = userAnswerId;
        this.userOldAnswerId = userOldAnswerId;
    }

    public boolean isEdited() {
        if (userOldAnswerId==null) {
            return  userAnswerId!=null;
        }
        return !userOldAnswerId.equals(userAnswerId);
    }

    public boolean isNull() {
        return questionId==null;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public Integer getUserAnswerId() {
        return userAnswerId;
    }

    public Integer getuserOldAnswerId() {
        return userOldAnswerId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public void setUserAnswerId(Integer userAnswerId) {
        this.userAnswerId = userAnswerId;
    }

    public void setUserOldAnswerId(Integer userOldAnswerId) {
        this.userOldAnswerId = userOldAnswerId;
    }
}
