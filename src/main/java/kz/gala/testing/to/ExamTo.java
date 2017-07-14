package kz.gala.testing.to;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import kz.gala.testing.model.Answer;
import kz.gala.testing.model.BaseEntity;
import kz.gala.testing.model.Question;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

//смотрим на все поля, не смотрим на геттеры, на is- геттеры, на сеттеры
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class ExamTo  {

    private final Integer questionId;

    private final String questionBody;

    private final List<Answer> answers;

    private final Integer nextQuestionId;

    private final Integer prevQuestionId;

    private final Integer userAnswerId;

    private final Integer userOldAnswerId;

    public ExamTo(Question question, List<Answer> answers, Integer nextId, Integer prevId, Integer userAnswerId, Integer userOldAnswerId) {
        this.questionId = question.getId();
        this.questionBody = question.getBody();
        this.answers = answers;
        this.nextQuestionId = nextId;
        this.prevQuestionId = prevId;
        this.userAnswerId = userAnswerId;
        this.userOldAnswerId = userOldAnswerId;
    }

    public ExamTo(Question question, List<Answer> answers, Integer nextId, Integer prevId, Integer userAnswerId) {
        this.questionId = question.getId();
        this.questionBody = question.getBody();
        this.answers = answers;
        this.nextQuestionId = nextId;
        this.prevQuestionId = prevId;
        this.userAnswerId = userAnswerId;
        this.userOldAnswerId = userAnswerId;
    }

    public boolean isEdited() {
            return !(userAnswerId == userOldAnswerId);
    }
}
