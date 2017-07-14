package kz.gala.testing.to;

import kz.gala.testing.model.Answer;
import kz.gala.testing.model.BaseEntity;
import kz.gala.testing.model.Question;

import java.util.List;

public class ExamTo {

    private final Integer id;

    private final String body;

    private final List<Answer> answers;

    private final Integer nextId;

    private final Integer prevId;

    private final Integer userAnswerId;

    private final Integer oldUserAnswerId;


    public ExamTo(Question question, List<Answer> answers, Integer nextId, Integer prevId, Integer userAnswerId, Integer oldUserAnswerId) {
        this.id = question.getId();
        this.body = question.getBody();
        this.answers = answers;
        this.nextId = nextId;
        this.prevId = prevId;
        this.userAnswerId = userAnswerId;
        this.oldUserAnswerId = oldUserAnswerId;
    }

    public ExamTo(Question question, List<Answer> answers, Integer nextId, Integer prevId, Integer userAnswerId) {
        this.id = question.getId();
        this.body = question.getBody();
        this.answers = answers;
        this.nextId = nextId;
        this.prevId = prevId;
        this.userAnswerId = userAnswerId;
        this.oldUserAnswerId = userAnswerId;
    }
}

