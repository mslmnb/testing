package kz.gala.testing.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
    @NamedQuery(name = Question.BY_ID, query = "SELECT q FROM Question q LEFT JOIN FETCH q.answers WHERE q.id=:id" )
})

@Entity
@Table(name="questions")
public class Question extends BaseEntity{
    public static final String BY_ID = "Question.getById";

    @Column(name="body", nullable=false)
    private String body;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    private List<Answer> answers;

    @Column(name="right_answer_id", nullable = false)
    private Integer rightAnswerId;                        // не отдавать на UI

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Integer getRightAnswerId() {
        return rightAnswerId;
    }

    public void setRightAnswerId(Integer rightAnswerId) {
        this.rightAnswerId = rightAnswerId;
    }
}
