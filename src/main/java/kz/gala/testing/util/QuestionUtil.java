package kz.gala.testing.util;

import kz.gala.testing.model.Answer;
import kz.gala.testing.model.Question;
import kz.gala.testing.model.Theme;
import kz.gala.testing.to.AnswerTo;
import kz.gala.testing.to.QuestionTo;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionUtil {

    public static QuestionTo asTo(Question question) {
        return new QuestionTo(question.getId(), question.getBody());
    }

    public static List<QuestionTo> convertToListQuestionTo(List<Question> questions) {
        return questions.stream().map(q->asTo(q)).collect(Collectors.toList());
    }
}
