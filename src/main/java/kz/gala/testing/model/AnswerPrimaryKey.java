package kz.gala.testing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class AnswerPrimaryKey implements Serializable { //обязательно должно быть

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    @JsonIgnore
    private Question question;

    @Column(name="enum")
    private Integer enumerator;

    public AnswerPrimaryKey() {
    }

    public AnswerPrimaryKey(Integer questionId, Integer enumerator) {
        this.question = new Question(questionId);
        this.enumerator = enumerator;
    }


    public AnswerPrimaryKey(Question question, Integer enumerator) {
        this.question = question;
        this.enumerator = enumerator;
    }

    public Integer getQuestionId() {
        return question.getId();
    }

    public Integer getEnumerator() {
        return enumerator;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setEnumerator(Integer enumerator) {
        this.enumerator = enumerator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnswerPrimaryKey that = (AnswerPrimaryKey) o;

        if (!question.equals(that.question)) return false;
        return enumerator.equals(that.enumerator);

    }

    @Override
    public int hashCode() {
        int result = question.hashCode();
        result = 31 * result + enumerator.hashCode();
        return result;
    }
}
