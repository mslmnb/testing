package kz.gala.testing.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@SuppressWarnings("JpaQlInspection")
@NamedQueries({
    @NamedQuery(name = Exam.FIRST, query = "SELECT e FROM Exam e WHERE e.id.userId=:userId ORDER BY e.id.questionId"),
    @NamedQuery(name = Exam.LAST, query = "SELECT e FROM Exam e WHERE e.id.userId=:userId ORDER BY e.id.questionId DESC"),
    @NamedQuery(name = Exam.NEXT, query = "SELECT e FROM Exam e WHERE e.id.questionId>=:questionId AND e.id.userId=:userId ORDER BY e.id.questionId "),
    @NamedQuery(name = Exam.PREVIOUS, query = "SELECT e FROM Exam e WHERE e.id.questionId<=:questionId AND e.id.userId=:userId ORDER BY e.id.questionId DESC "),
    @NamedQuery(name = Exam.ALL, query = "SELECT e FROM Exam e WHERE e.id.userId=:userId ORDER BY e.id.questionId")
})

//смотрим на все поля, не смотрим на геттеры, на is- геттеры, на сеттеры
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)


@Entity
@Table(name = "exam", uniqueConstraints = {@UniqueConstraint(columnNames ={"user_id", "question_id"}, name = "exam_unique_user_question_idx")})
public class Exam { //implements Serializable

    public static final String FIRST = "Exam.getFirst";
    public static final String LAST = "Exam.getLast";
    public static final String NEXT = "Exam.getNext";
    public static final String PREVIOUS = "Exam.getPrevious";
    public static final String ALL = "Exam.getAll";

    @Id
    private ExamPrimaryKey primaryKey;

    //  каждый ответ имеет порядковый номер enumerator
    // enumerator указывает порядковый номер бита для данного ответа
    // userAnswerEnums - набор битовой информации
    // если соответствующий ответ был выбран пользователем, то соответствующий бит равен 1
    @Column(name = "user_answer_enums")
    private Integer userAnswerEnums;

    public ExamPrimaryKey getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(ExamPrimaryKey primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Exam(Integer userId, Integer questionId, Integer userAnswerEnums) {
        this.primaryKey = new ExamPrimaryKey(userId, questionId);
        this.userAnswerEnums = userAnswerEnums;
    }


    public Exam(ExamPrimaryKey primaryKey, Integer userAnswerEnums) {
        this.primaryKey = primaryKey;
        this.userAnswerEnums = userAnswerEnums;
    }

    public Exam() {
    }

    public void setUserAnswerEnums(Integer userAnswerEnums) {
        this.userAnswerEnums = userAnswerEnums;
    }

    public Integer getUserAnswerEnums() {
        return userAnswerEnums;
    }

    public Integer getQuestionId() {
        return primaryKey.getQuestionId();
    }

    public Integer getUserId() {
        return primaryKey.getUserId();
    }

    @Override
    public String toString() {
        return "Exam{" +
                "userId=" + getUserId() +
                ", questionId=" + getQuestionId() +
                ", userAnswerEnums=" + userAnswerEnums +
                '}';
    }
}


