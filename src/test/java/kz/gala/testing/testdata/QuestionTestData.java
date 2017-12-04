package kz.gala.testing.testdata;

import kz.gala.testing.matcher.ModelMatcher;
import kz.gala.testing.model.Answer;
import kz.gala.testing.model.Question;

import static kz.gala.testing.model.BaseEntity.START_SEQ;
import static kz.gala.testing.testdata.ThemeTestData.THEME1;

/**
 * Created by Mussulmanbekova_GE on 03.07.2017.
 */
public class QuestionTestData {

    public final static ModelMatcher<Question> MATCHER = ModelMatcher.of(Question.class);

    public static final int QUESTION1_ID = START_SEQ + 20;
    public static final int ANSWER1_ID = START_SEQ + 40;

    public static final Question QUESTION1 = new Question(QUESTION1_ID, THEME1, "Земля по форме похожа на", 3);
    public static final Question QUESTION2 = new Question(QUESTION1_ID + 1, THEME1, "Колобок был съеден", 4);
    public static final Question QUESTION3 = new Question(QUESTION1_ID + 2, THEME1, "Дети любят", 1);
    public static final Question QUESTION4 = new Question(QUESTION1_ID + 3, THEME1, "Светофор имеет цвет", 4);
    public static final Question QUESTION5 = new Question(QUESTION1_ID + 4, THEME1, "Караганда это", 1);
    public static final Question QUESTION6 = new Question(QUESTION1_ID + 5, THEME1, "Два умножить на два равно", 2);
    public static final Question QUESTION7 = new Question(QUESTION1_ID + 6, THEME1, "Луна вращается вокруг", 1);
    public static final Question QUESTION8 = new Question(QUESTION1_ID + 7, THEME1, "Дюймовочка была ростом", 1);
    public static final Question QUESTION9 = new Question(QUESTION1_ID + 8, THEME1, "Яблоко это", 4);

    public static final Answer ANSWER1 = new Answer(QUESTION1, 0, "мяч");
    public static final Answer ANSWER2 = new Answer(QUESTION1, 1, "шар");
    public static final Answer ANSWER3 = new Answer(QUESTION1, 2, "куб");

    public static final Answer ANSWER4 = new Answer(QUESTION2, 0, "Дюймовочкой");
    public static final Answer ANSWER5 = new Answer(QUESTION2, 1, "Чебурашкой");
    public static final Answer ANSWER6 = new Answer(QUESTION2, 2, "лисой");

    public static final Answer ANSWER7 = new Answer(QUESTION3, 0,  "играть");
    public static final Answer ANSWER8 = new Answer(QUESTION3, 1, "стоять в углу");
    public static final Answer ANSWER9 = new Answer(QUESTION3, 2, "рыбий жиру");

    public static final Answer ANSWER10 = new Answer(QUESTION4, 0, "черный");
    public static final Answer ANSWER11 = new Answer(QUESTION4, 1, "розовый");
    public static final Answer ANSWER12 = new Answer(QUESTION4, 2, "желтый");

    public static final Answer ANSWER13 = new Answer(QUESTION5, 0, "город");
    public static final Answer ANSWER14 = new Answer(QUESTION5, 1, "поселок");
    public static final Answer ANSWER15 = new Answer(QUESTION5, 2, "район");

    public static final Answer ANSWER16 = new Answer(QUESTION6, 0, "ноль");
    public static final Answer ANSWER17 = new Answer(QUESTION6, 1, "четыре");
    public static final Answer ANSWER18 = new Answer(QUESTION6, 2, "десять");

    public static final Answer ANSWER19 = new Answer(QUESTION7, 0, "Земли");
    public static final Answer ANSWER20 = new Answer(QUESTION7, 1, "Марса");
    public static final Answer ANSWER21 = new Answer(QUESTION7, 2, "Сатурна");

    public static final Answer ANSWER22 = new Answer(QUESTION8, 0, "дюйм");
    public static final Answer ANSWER23 = new Answer(QUESTION8, 1, "метр");
    public static final Answer ANSWER24 = new Answer(QUESTION8, 2, "полтора метра");

    public static final Answer ANSWER25 = new Answer(QUESTION9, 0, "овощ");
    public static final Answer ANSWER26 = new Answer(QUESTION9, 1, "ягода");
    public static final Answer ANSWER27 = new Answer(QUESTION9, 2, "фрукт");

//    static {
//        QUESTION1.setCorrectAnswerId(ANSWER1_ID + 1);
//        QUESTION2.setCorrectAnswerId(ANSWER1_ID + 5);
//        QUESTION3.setCorrectAnswerId(ANSWER1_ID + 6);
//        QUESTION4.setCorrectAnswerId(ANSWER1_ID + 11);
//        QUESTION5.setCorrectAnswerId(ANSWER1_ID + 12);
//        QUESTION6.setCorrectAnswerId(ANSWER1_ID + 16);
//        QUESTION7.setCorrectAnswerId(ANSWER1_ID + 18);
//        QUESTION8.setCorrectAnswerId(ANSWER1_ID + 21);
//        QUESTION9.setCorrectAnswerId(ANSWER1_ID + 26);
//    }

    private QuestionTestData() {

    }
}
