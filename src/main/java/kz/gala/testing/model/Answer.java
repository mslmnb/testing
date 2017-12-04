package kz.gala.testing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Mussulmanbekova_GE on 14.06.2017.
 */
@Entity
@Table(name="answers")
public class Answer { //implements Serializable

    @Column(name="body", nullable = false)
    @NotNull
    private String body;

    @Id
    private AnswerPrimaryKey primaryKey;

    public Answer(Question question, Integer enumerator, String body) {
        this.primaryKey = new AnswerPrimaryKey(question, enumerator);
        this.body = body;
    }

    public Answer() {
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }


    public Integer getQuestionId() {
        return primaryKey.getQuestionId();
    }

    public Integer getEnumerator() {
        return primaryKey.getEnumerator();
    }


    @Override
    public String toString() {
        return "Answer{" +
                "question_id=" + getQuestionId() +
                "enum=" + getEnumerator() +
                "body='" + body + '\'' +
                '}';
    }
}
