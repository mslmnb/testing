package kz.gala.testing.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@NamedQueries({
    @NamedQuery(name = Question.BY_ID, query = "SELECT q FROM Question q LEFT JOIN FETCH q.answers WHERE q.id=:id" )
})

@Entity
@Table(name="questions")
public class Question extends BaseEntity{
    public static final String BY_ID = "Question.getById";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id")//, nullable = false)
    //@NotNull
    private Theme theme;

    @Column(name="body", nullable=false)
    @NotNull
    private String body;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "primaryKey.question")
    private List<Answer> answers;

    @Column(name="correct_answer_enums") //, nullable = false)
    //@NotNull
    private Integer correctAnswerEnums;                        // не отдавать на UI

    public Question() {
    }

    public Question (Integer id) {
        super(id);
    }

    public Question (Integer id, String body) {
        super(id);
        this.body = body;
        correctAnswerEnums = 0;
    }

    public Question (Integer id, Theme theme,String body) {
        super(id);
        this.theme = theme;
        this.body = body;
        correctAnswerEnums = 0;
    }

    public Question (Integer id, Theme theme,String body, Integer correctAnswerEnums) {
        super(id);
        this.theme = theme;
        this.body = body;
        this.correctAnswerEnums = correctAnswerEnums;
    }

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

    public Integer getCorrectAnswerEnums() {
        return correctAnswerEnums;
    }

    public void setCorrectAnswerEnums(Integer correctAnswerEnums) {
        this.correctAnswerEnums = correctAnswerEnums;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Theme getTheme() {
        return theme;
    }

    @Override
    public String toString() {
        return "Question{" +
                //"themeId=" + theme.getId() +
                ", body='" + body + '\'' +
                '}';
    }
}
