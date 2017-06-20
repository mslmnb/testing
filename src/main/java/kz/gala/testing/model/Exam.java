package kz.gala.testing.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Mussulmanbekova_GE on 15.06.2017.
 */

@SuppressWarnings("JpaQlInspection")
@NamedQueries({
    @NamedQuery(name = Exam.GET_FIRST, query = "SELECT e FROM Exam e WHERE e.id.userId=:userId ORDER BY e.id.questionId"),
    @NamedQuery(name = Exam.GET_LAST, query = "SELECT e FROM Exam e WHERE e.id.userId=:userId ORDER BY e.id.questionId DESC"),
    @NamedQuery(name = Exam.GET_NEXT, query = "SELECT e FROM Exam e WHERE e.id.questionId>=:id AND e.id.userId=:userId ORDER BY e.id.questionId "),
    @NamedQuery(name = Exam.GET_PREVIOUS, query = "SELECT e FROM Exam e WHERE e.id.questionId<=:id AND e.id.userId=:userId ORDER BY e.id.questionId DESC ")
})


@Entity
@Table(name = "exam", uniqueConstraints = {@UniqueConstraint(columnNames ={"user_id", "question_id"}, name = "exam_unique_user_question_idx")})
public class Exam implements Serializable{

    public static final String GET_FIRST = "Exam.getFirst";
    public static final String GET_LAST = "Exam.getLast";
    public static final String GET_NEXT = "Exam.getNext";
    public static final String GET_PREVIOUS = "Exam.getPrevious";

    @Id
    private ExamPrimaryKey id;

    public ExamPrimaryKey getId() {
        return id;
    }

    public void setId(ExamPrimaryKey id) {
        this.id = id;
    }

    //@Column(name = "question_id", nullable = false)
    //@NotBlank
    //private Integer questionId;

    @Column(name = "user_answer_id")
    private Integer userAnswerId;

    //@Column(name = "user_id")
    //@NotBlank
    //private Integer user_id;

//    public Integer getQuestionId() {
//        return questionId;
//    }

    public Integer getQuestionId() {
        return id.getQuestionId();
    }

//    public void setQuestionId(Integer questionId) {
//        this.questionId = questionId;
//    }

    public void setQuestionId(Integer questionId) {
        id.setQuestionId(questionId);
    }
    public Integer getUserAnswerId() {
        return userAnswerId;
    }

    public void setUserAnswerId(Integer userAnswerId) {
        this.userAnswerId = userAnswerId;
    }
}


