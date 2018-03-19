package kz.gala.testing.service;

import kz.gala.testing.model.Exam;
import kz.gala.testing.util.exception.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;

import static kz.gala.testing.testdata.ExamTestData.*;
import static kz.gala.testing.testdata.ThemeTestData.THEME1_ID;
import static kz.gala.testing.testdata.UserTestData.USER_ID;


public class ExamServiceTest extends AbstractServiceTest {

    @Autowired
    private ExamService service;

    @Autowired
    private QuestionService questionService;



    @Test
    public void testGetNextFrom() throws Exception {
        MATCHER.assertCollectionEquals(Arrays.asList(EXAM1, EXAM2, EXAM3), service.getNextFrom(EXAM1.getQuestionId(), USER_ID));
        MATCHER.assertCollectionEquals(Arrays.asList(EXAM8, EXAM9), service.getNextFrom(EXAM8.getQuestionId(), USER_ID));
    }

    @Test
    public void testGetPreviousFrom() throws Exception {
        MATCHER.assertCollectionEquals(Arrays.asList(EXAM2, EXAM1), service.getPreviousFrom(EXAM2.getQuestionId(), USER_ID));
        MATCHER.assertCollectionEquals(Arrays.asList(EXAM3, EXAM2, EXAM1), service.getPreviousFrom(EXAM3.getQuestionId(), USER_ID));
    }

    @Test
    public void testGetFirst() throws Exception {
        MATCHER.assertCollectionEquals(Arrays.asList(EXAM1, EXAM2),service.getFirst(USER_ID));
    }

    @Test
    public void testGetLast() throws Exception {
        MATCHER.assertCollectionEquals(Arrays.asList(EXAM9, EXAM8), service.getLast(USER_ID));
    }

    @Test
    public void testGet() {
        MATCHER.assertEquals(EXAM1, service.get(EXAM1.getQuestionId(),EXAM1.getUserId()));
    }

    @Test
    public void testGetNotFound() {

        int userId = EXAM1.getPrimaryKey().getUserId() + 1 ;
        int questionId = EXAM1.getPrimaryKey().getQuestionId();

        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Not found entity with id=[" +userId + ", " + questionId + "]");
        service.get(questionId,userId);
    }

    @Test
    public void testGetAll() {
        MATCHER.assertCollectionEquals(Arrays.asList(EXAM1, EXAM2, EXAM3, EXAM4, EXAM5, EXAM6, EXAM7, EXAM8, EXAM9), service.getAll(USER_ID));
    }

    @Test
    public void testUpdateNotFound() {

        int questionId = EXAM1.getPrimaryKey().getQuestionId();
        int userId = EXAM1.getPrimaryKey().getUserId() + 1;

        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Not found entity with id=[" +userId + ", " + questionId + "]");
        service.update(EXAM1, userId);
    }

    @Test
    public void testUpdate() throws Exception {
        int questionId = EXAM1.getQuestionId();
        int userId = EXAM1.getUserId();
        int userAnswerEnums = questionService.get(questionId, THEME1_ID).getCorrectAnswerEnums();
        EXAM1.setUserAnswerEnums(userAnswerEnums);
        service.update(EXAM1, userId);
        MATCHER.assertEquals(EXAM1, service.get(questionId,userId));
    }

    @Test
    public void testGetExamReport() {
        MATCHER_REPORT.assertEquals(EXAM_REPORT, service.getExamReport(USER_ID, THEME1_ID));
    }

    @Test
    public void testDeleteAllFor() throws Exception {
        service.deleteAllFor(USER_ID);
        MATCHER.assertCollectionEquals(new ArrayList<Exam>(), service.getAll(USER_ID));
    }

    @Test
    public void testDeleteNotFound() {
        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Not found entity with id=" + (USER_ID-1) );
        service.deleteAllFor(USER_ID-1);
    }

    @Test
    public void testInsert() {
        service.deleteAllFor(USER_ID);
        service.insertFor(USER_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(EXAM1, EXAM2, EXAM3, EXAM4, EXAM5, EXAM6, EXAM7, EXAM8, EXAM9), service.getAll(USER_ID));
    }

    @Test
    public void testIsComplete() {
        Assert.assertEquals(false, service.isComplete(USER_ID));
    }
}