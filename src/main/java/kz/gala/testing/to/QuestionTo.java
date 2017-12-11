package kz.gala.testing.to;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import kz.gala.testing.model.Question;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

//смотрим на все поля, не смотрим на геттеры, на is- геттеры, на сеттеры
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class QuestionTo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String body;

    public QuestionTo() {
    }

    public QuestionTo(Integer id, String body) {
        this.id = id;
        this.body = body;
    }

    public QuestionTo(Question q) {
        this.id = q.getId();
        this.body = q.getBody();
    }

    public Integer getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
