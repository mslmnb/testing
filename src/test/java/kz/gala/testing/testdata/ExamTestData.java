package kz.gala.testing.testdata;

import kz.gala.testing.matcher.ModelMatcher;
import kz.gala.testing.model.Exam;
import kz.gala.testing.model.ExamPrimaryKey;

import static kz.gala.testing.testdata.QuestionTestData.QUESTION1_ID;
import static kz.gala.testing.testdata.UserTestData.USER_ID;

/**
 * Created by Mussulmanbekova_GE on 04.07.2017.
 */
public class ExamTestData {

    public final static ModelMatcher<Exam> MATCHER = ModelMatcher.of(Exam.class);

    public static final Exam EXAM1 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID), null);
    public static final Exam EXAM2 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID + 1), null);
    public static final Exam EXAM3 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID + 2), null);
    public static final Exam EXAM4 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID + 3), null);
    public static final Exam EXAM5 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID + 4), null);
    public static final Exam EXAM6 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID + 5), null);
    public static final Exam EXAM7 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID + 6), null);
    public static final Exam EXAM8 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID + 7), null);
    public static final Exam EXAM9 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID + 8), null);

    private ExamTestData() {
    }
}
