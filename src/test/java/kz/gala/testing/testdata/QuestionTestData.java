package kz.gala.testing.testdata;

import kz.gala.testing.model.Answer;
import kz.gala.testing.model.Question;

import static kz.gala.testing.model.BaseEntity.START_SEQ;
import static kz.gala.testing.testdata.ThemeTestData.THEME1;

/**
 * Created by Mussulmanbekova_GE on 03.07.2017.
 */
public class QuestionTestData {

    public static final int QUESTION1_ID = START_SEQ + 20;
    public static final int ANSWER1_ID = START_SEQ + 40;

    public static final Question QUESTION1 = new Question(QUESTION1_ID, THEME1, "Земля по форме похожа на");
    public static final Question QUESTION2 = new Question(QUESTION1_ID + 1, THEME1, "Колобок был съеден");
    public static final Question QUESTION3 = new Question(QUESTION1_ID + 2, THEME1, "Дети любят");
    public static final Question QUESTION4 = new Question(QUESTION1_ID + 3, THEME1, "Светофор имеет цвет");
    public static final Question QUESTION5 = new Question(QUESTION1_ID + 4, THEME1, "Караганда это");
    public static final Question QUESTION6 = new Question(QUESTION1_ID + 5, THEME1, "Два умножить на два равно");
    public static final Question QUESTION7 = new Question(QUESTION1_ID + 6, THEME1, "Луна вращается вокруг");
    public static final Question QUESTION8 = new Question(QUESTION1_ID + 7, THEME1, "Дюймовочка была ростом");
    public static final Question QUESTION9 = new Question(QUESTION1_ID + 8, THEME1, "Яблоко это");

    public static final Answer ANSWER1 = new Answer(ANSWER1_ID, QUESTION1, "конус");
    public static final Answer ANSWER2 = new Answer(ANSWER1_ID + 1, QUESTION1, "шар");
    public static final Answer ANSWER3 = new Answer(ANSWER1_ID + 2, QUESTION1, "куб");

    public static final Answer ANSWER4 = new Answer(ANSWER1_ID + 3, QUESTION2, "Дюймовочкой");
    public static final Answer ANSWER5 = new Answer(ANSWER1_ID + 4, QUESTION2, "Чебурашкой");
    public static final Answer ANSWER6 = new Answer(ANSWER1_ID + 5, QUESTION2, "лисой");

    public static final Answer ANSWER7 = new Answer(ANSWER1_ID + 6, QUESTION3, "играть");
    public static final Answer ANSWER8 = new Answer(ANSWER1_ID + 7, QUESTION3, "стоять в углу");
    public static final Answer ANSWER9 = new Answer(ANSWER1_ID + 8, QUESTION3, "рыбий жиру");

    public static final Answer ANSWER10 = new Answer(ANSWER1_ID + 9, QUESTION4, "черный");
    public static final Answer ANSWER11 = new Answer(ANSWER1_ID + 10, QUESTION4, "розовый");
    public static final Answer ANSWER12 = new Answer(ANSWER1_ID + 11, QUESTION4, "желтый");

    public static final Answer ANSWER13 = new Answer(ANSWER1_ID + 12, QUESTION5, "город");
    public static final Answer ANSWER14 = new Answer(ANSWER1_ID + 13, QUESTION5, "поселок");
    public static final Answer ANSWER15 = new Answer(ANSWER1_ID + 14, QUESTION5, "район");

    public static final Answer ANSWER16 = new Answer(ANSWER1_ID + 15, QUESTION6, "ноль");
    public static final Answer ANSWER17 = new Answer(ANSWER1_ID + 16, QUESTION6, "четыре");
    public static final Answer ANSWER18 = new Answer(ANSWER1_ID + 17, QUESTION6, "десять");

    public static final Answer ANSWER19 = new Answer(ANSWER1_ID + 18, QUESTION7, "Земли");
    public static final Answer ANSWER20 = new Answer(ANSWER1_ID + 19, QUESTION7, "Марса");
    public static final Answer ANSWER21 = new Answer(ANSWER1_ID + 20, QUESTION7, "Сатурна");

    public static final Answer ANSWER22 = new Answer(ANSWER1_ID + 21, QUESTION8, "дюйм");
    public static final Answer ANSWER23 = new Answer(ANSWER1_ID + 22, QUESTION8, "метр");
    public static final Answer ANSWER24 = new Answer(ANSWER1_ID + 23, QUESTION8, "полтора метра");

    public static final Answer ANSWER25 = new Answer(ANSWER1_ID + 24, QUESTION9, "овощ");
    public static final Answer ANSWER26 = new Answer(ANSWER1_ID + 25, QUESTION9, "ягода");
    public static final Answer ANSWER27 = new Answer(ANSWER1_ID + 26, QUESTION9, "фрукт");

    static {
        QUESTION1.setRightAnswerId(ANSWER1_ID + 1);
        QUESTION2.setRightAnswerId(ANSWER1_ID + 5);
        QUESTION3.setRightAnswerId(ANSWER1_ID + 6);
        QUESTION4.setRightAnswerId(ANSWER1_ID + 11);
        QUESTION5.setRightAnswerId(ANSWER1_ID + 12);
        QUESTION6.setRightAnswerId(ANSWER1_ID + 16);
        QUESTION7.setRightAnswerId(ANSWER1_ID + 18);
        QUESTION8.setRightAnswerId(ANSWER1_ID + 21);
        QUESTION9.setRightAnswerId(ANSWER1_ID + 26);
    }

    private QuestionTestData() {
    }
}
