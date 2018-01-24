package kz.gala.testing.to;

import kz.gala.testing.model.BaseEntity;


public class AnswerWithCorrect extends BaseEntity {
    private String body;
    private Boolean correct;

    public AnswerWithCorrect() {
    }

    public AnswerWithCorrect(Integer id, String body, Boolean correct) {
        super(id);
        this.body = body;
        this.correct = correct;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
