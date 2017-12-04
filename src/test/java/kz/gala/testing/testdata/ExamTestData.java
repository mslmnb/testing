package kz.gala.testing.testdata;

import kz.gala.testing.matcher.ModelMatcher;
import kz.gala.testing.model.Exam;
import kz.gala.testing.to.ExamReport;

import java.util.Collections;

import static kz.gala.testing.testdata.QuestionTestData.*;
import static kz.gala.testing.testdata.UserTestData.USER;
import static kz.gala.testing.testdata.UserTestData.USER_ID;

public class ExamTestData {

    public final static ModelMatcher<Exam> MATCHER = ModelMatcher.of(Exam.class);
    public final static ModelMatcher<ExamReport> MATCHER_REPORT = ModelMatcher.of(ExamReport.class);

    public static final Exam EXAM1 = new Exam(USER.getId(), QUESTION1.getId(), 0);
    public static final Exam EXAM2 = new Exam(USER.getId(), QUESTION2.getId(), 0);
    public static final Exam EXAM3 = new Exam(USER.getId(), QUESTION3.getId(), 0);
    public static final Exam EXAM4 = new Exam(USER.getId(), QUESTION4.getId(), 0);
    public static final Exam EXAM5 = new Exam(USER.getId(), QUESTION5.getId(), 0);
    public static final Exam EXAM6 = new Exam(USER.getId(), QUESTION6.getId(), 0);
    public static final Exam EXAM7 = new Exam(USER.getId(), QUESTION7.getId(), 0);
    public static final Exam EXAM8 = new Exam(USER.getId(), QUESTION8.getId(), 0);
    public static final Exam EXAM9 = new Exam(USER.getId(), QUESTION9.getId(), 0);

    public static final ExamReport EXAM_REPORT = new ExamReport(USER,9,0,0);

    private ExamTestData() {
    }
}
