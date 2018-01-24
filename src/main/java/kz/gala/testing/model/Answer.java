package kz.gala.testing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.gala.testing.to.AnswerTo;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="answers")
//  если убрать implements Serializable при вызове метода CrudAnswerRepository.findOne(...) получаю ошибку
//  Resolving exception from handler [public kz.gala.testing.to.AnswerTo kz.gala.testing.web.answer.AnswerAjaxController.getTo(int,int)]: org.hibernate.LazyInitializationException: could not initialize proxy - no Session
public class Answer implements Serializable{

    @Id
    private AnswerPrimaryKey primaryKey;

    @Column(name="body", nullable = false)
    @NotNull
    private String body;

    public Answer() {
    }

    public Answer(AnswerPrimaryKey primaryKey, String body) {
        this.body = body;
        this.primaryKey = primaryKey;
    }

    public Answer(Question question, Integer enumerator, String body) {
        this(new AnswerPrimaryKey(question, enumerator), body);
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }


    public Integer getQuestionId() {
        return primaryKey==null ? null : primaryKey.getQuestionId();
    }

    public AnswerPrimaryKey getPrimaryKey() {
        return primaryKey;
    }

    public Integer getEnumerator() {
        return primaryKey.getEnumerator();
    }

    public void setPrimaryKey(AnswerPrimaryKey primaryKey) {
        this.primaryKey = primaryKey;
    }

    public void setPrimaryKey(Integer questionId, Integer enumerator) {
        this.primaryKey = new AnswerPrimaryKey(questionId, enumerator);
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
