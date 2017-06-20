package kz.gala.testing.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Mussulmanbekova_GE on 14.06.2017.
 */
@Entity
@Table(name="answers")
public class Answer extends BaseEntity {

    @Column(name="body", nullable = false)
    @NotBlank
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Question question;

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + getId() +
                "body='" + body + '\'' +
                '}';
    }
}
