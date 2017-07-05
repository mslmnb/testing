package kz.gala.testing.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mussulmanbekova_GE on 15.06.2017.
 */

@SuppressWarnings("JpaQlInspection")
@NamedQueries({
    @NamedQuery(name = Exam.FIRST, query = "SELECT e FROM Exam e WHERE e.id.userId=:userId ORDER BY e.id.questionId"),
    @NamedQuery(name = Exam.LAST, query = "SELECT e FROM Exam e WHERE e.id.userId=:userId ORDER BY e.id.questionId DESC"),
    @NamedQuery(name = Exam.NEXT, query = "SELECT e FROM Exam e WHERE e.id.questionId>=:questionId AND e.id.userId=:userId ORDER BY e.id.questionId "),
    @NamedQuery(name = Exam.PREVIOUS, query = "SELECT e FROM Exam e WHERE e.id.questionId<=:questionId AND e.id.userId=:userId ORDER BY e.id.questionId DESC "),
})


@Entity
@Table(name = "exam", uniqueConstraints = {@UniqueConstraint(columnNames ={"user_id", "question_id"}, name = "exam_unique_user_question_idx")})
public class Exam implements Serializable{

    public static final String FIRST = "Exam.getFirst";
    public static final String LAST = "Exam.getLast";
    public static final String NEXT = "Exam.getNext";
    public static final String PREVIOUS = "Exam.getPrevious";

    @Id
    private ExamPrimaryKey id;

    public ExamPrimaryKey getId() {
        return id;
    }

    public void setId(ExamPrimaryKey id) {
        this.id = id;
    }

    @Column(name = "user_answer_id")
    private Integer userAnswerId;

    public Exam(ExamPrimaryKey id, Integer userAnswerId) {
        this.id = id;
        this.userAnswerId = userAnswerId;
    }

    public Exam(Integer questionId, Integer userId, Integer userAnswerId) {
        this(new ExamPrimaryKey(userId, questionId), userAnswerId);
    }

    public Exam() {
    }

    public Integer getQuestionId() {
        return id.getQuestionId();
    }

    public Integer getUserId() {
        return id.getUserId();
    }

    public void setQuestionId(Integer questionId) {
        id.setQuestionId(questionId);
    }
    public Integer getUserAnswerId() {
        return userAnswerId;
    }

    public void setUserAnswerId(Integer userAnswerId) {
        this.userAnswerId = userAnswerId;
    }



    @Override
    public String toString() {
        return "Exam{" +
                "userId=" + id.getUserId() +
                ", questionId=" + id.getQuestionId() +
                ", userAnswerId=" + userAnswerId +
                '}';
    }
}


