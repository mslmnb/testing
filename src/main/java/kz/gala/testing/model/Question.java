package kz.gala.testing.model;

import java.util.ArrayList;

/**
 * Created by Mussulmanbekova_GE on 14.06.2017.
 */
public class Question implements HasId{
    private Integer id;
    private String body;
    private ArrayList<Answer> answers;
    private Integer rightAnswerId;

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
