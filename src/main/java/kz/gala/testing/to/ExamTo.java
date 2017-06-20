package kz.gala.testing.to;

import kz.gala.testing.model.Answer;
import kz.gala.testing.model.HasId;

import java.util.ArrayList;

/**
 * Created by Mussulmanbekova_GE on 19.06.2017.
 */
public class ExamTo {

    private final Integer id;

    private final Integer questionId;

    private final Integer userAnswerId;

    private final ArrayList<Answer> answers;

    public ExamTo(Integer id, Integer questionId, Integer userAnswerId, ArrayList<Answer> answers) {
        this.id = id;
        this.questionId = questionId;
        this.userAnswerId = userAnswerId;
        this.answers = answers;
    }
}
