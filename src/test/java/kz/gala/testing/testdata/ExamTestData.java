package kz.gala.testing.testdata;

import kz.gala.testing.matcher.ModelMatcher;
import kz.gala.testing.model.Exam;
import kz.gala.testing.model.ExamPrimaryKey;
import kz.gala.testing.to.ExamReport;

import static kz.gala.testing.testdata.QuestionTestData.*;
import static kz.gala.testing.testdata.UserTestData.USER;
import static kz.gala.testing.testdata.UserTestData.USER_ID;

public class ExamTestData {

    public final static ModelMatcher<Exam> MATCHER = ModelMatcher.of(Exam.class);
    public final static ModelMatcher<ExamReport> MATCHER_REPORT = ModelMatcher.of(ExamReport.class);

    public static final Exam EXAM1 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID), null);
    public static final Exam EXAM2 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID + 1), null);
    public static final Exam EXAM3 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID + 2), null);
    public static final Exam EXAM4 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID + 3), null);
    public static final Exam EXAM5 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID + 4), null);
    public static final Exam EXAM6 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID + 5), null);
    public static final Exam EXAM7 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID + 6), null);
    public static final Exam EXAM8 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID + 7), null);
    public static final Exam EXAM9 = new Exam(new ExamPrimaryKey(USER_ID, QUESTION1_ID + 8), null);

    public static final ExamReport EXAM_REPORT = new ExamReport(USER,9,0,0);

    private ExamTestData() {
    }
}
