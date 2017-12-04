package kz.gala.testing.to;

import java.io.Serializable;
import java.util.List;

public class QuestionWithUserAnswer implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer questionId;
    private Integer userAnswerEnums;
    private Boolean edited;

    public QuestionWithUserAnswer() {
    }

    public QuestionWithUserAnswer(Integer questionId, Integer userAnswerEnums, Boolean edited) {
        this.questionId = questionId;
        this.userAnswerEnums = userAnswerEnums;
        this.edited = edited;
    }

    public Boolean isEdited() {
        return edited;
    }

    public void setEdited(Boolean edited) {
        this.edited = edited;
    }

    public boolean isNull() {
        return questionId==null;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public Integer getUserAnswerEnums() {
        return userAnswerEnums;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public void setUserAnswerEnums(Integer userAnswerEnums) {
        this.userAnswerEnums = userAnswerEnums;
    }
}
