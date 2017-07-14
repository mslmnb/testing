package kz.gala.testing.to;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

/**
 * Created by Mussulmanbekova_GE on 14.07.2017.
 */

@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class UserAnswer {
    Integer questionId;
    Integer userAnswerId;
    Integer oldUserAnswerId;
    Integer userId;

    public UserAnswer(Integer questionId, Integer userAnswerId, Integer oldUserAnswerId, Integer userId) {
        this.questionId = questionId;
        this.userAnswerId = userAnswerId;
        this.oldUserAnswerId = oldUserAnswerId;
        this.userId = userId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public Integer getUserAnswerId() {
        return userAnswerId;
    }

    public Integer getOldUserAnswerId() {
        return oldUserAnswerId;
    }

    public Integer getUserId() {
        return userId;
    }
}
