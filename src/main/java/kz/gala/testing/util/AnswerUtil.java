package kz.gala.testing.util;

import kz.gala.testing.model.Answer;
import kz.gala.testing.model.AnswerPrimaryKey;
import kz.gala.testing.to.AnswerTo;
import kz.gala.testing.to.AnswerWithCorrect;

import java.util.List;
import java.util.stream.Collectors;

public class AnswerUtil {
    public static List<AnswerWithCorrect>  convertToListWithCorrect(List<Answer> answers, Integer correctAnswerEnums) {
            return answers.stream().map(a->createWithCorrect(a, correctAnswerEnums))
                            .collect(Collectors.toList());
    }

    public static boolean getIsCorrect(Answer answer, Integer correctAnswerEnums) {
        final int mask = (int) Math.pow(2, answer.getEnumerator());
        return mask==(correctAnswerEnums&mask);
    }


    public static AnswerWithCorrect createWithCorrect(Answer answer, Integer correctAnswerEnums) {
        boolean isCorrect =  getIsCorrect(answer, correctAnswerEnums);
        return new AnswerWithCorrect(answer.getEnumerator(), answer.getBody(), isCorrect);
    }

    public static AnswerTo asTo(Answer answer) {
        return new AnswerTo(answer.getEnumerator(), answer.getBody());
    }

    public static Answer createFromTo(AnswerTo answerTo, int questionId) {
        return new Answer(new AnswerPrimaryKey(questionId, answerTo.getId()),answerTo.getBody());
    }
}
