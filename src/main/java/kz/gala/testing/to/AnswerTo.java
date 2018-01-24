package kz.gala.testing.to;

import kz.gala.testing.model.Answer;
import kz.gala.testing.model.BaseEntity;

public class AnswerTo extends BaseEntity {
    private String body;
    public AnswerTo() {
    }

    public AnswerTo(Integer id, String body) {
        super(id);
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
