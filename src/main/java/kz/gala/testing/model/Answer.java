package kz.gala.testing.model;

/**
 * Created by Mussulmanbekova_GE on 14.06.2017.
 */
public class Answer implements HasId {
    private Integer id;
    private String body;

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getBody() {
        return body;
    }


}
