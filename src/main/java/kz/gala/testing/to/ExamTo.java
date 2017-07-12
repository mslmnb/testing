package kz.gala.testing.to;

import kz.gala.testing.model.Answer;
import kz.gala.testing.model.BaseEntity;

import java.util.List;

public class ExamTo {

    private final String body;

    private final List<Answer> answers;

    private final Integer nextId;

    private final Integer prevId;

    private final Integer userAnswerId;

    private final Integer oldUserAnswerId;


    public ExamTo(Integer id, String body, List<Answer> answers, Integer nextId, Integer prevId, Integer userAnswerId,Integer oldUserAnswerId) {
        //super(id);
        this.body = body;
        this.answers = answers;
        this.nextId = nextId;
        this.prevId = prevId;
        this.userAnswerId = userAnswerId;
        this.oldUserAnswerId = oldUserAnswerId;
    }

    public ExamTo(Integer id, String body, List<Answer> answers, Integer nextId, Integer prevId, Integer userAnswerId) {
        //super(id);
        this.body = body;
        this.answers = answers;
        this.nextId = nextId;
        this.prevId = prevId;
        this.userAnswerId = userAnswerId;
        this.oldUserAnswerId = userAnswerId;
    }
}

