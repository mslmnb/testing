package kz.gala.testing.to;

import kz.gala.testing.model.Answer;
import kz.gala.testing.model.BaseEntity;
import kz.gala.testing.model.Question;

import java.util.List;

public class ExamTo extends BaseEntity {

    private final String body;

    private final List<Answer> answers;

    private final Integer nextId;

    private final Integer prevId;

    private final Integer userAnswerId;

    public ExamTo(Integer id, String body, List<Answer> answers, Integer nextId, Integer prevId, Integer userAnswerId) {
        super(id);
        this.body = body;
        this.answers = answers;
        this.nextId = nextId;
        this.prevId = prevId;
        this.userAnswerId = userAnswerId;
    }
}
