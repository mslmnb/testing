package kz.gala.testing.service;

import kz.gala.testing.model.Exam;
import kz.gala.testing.util.exception.NotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static kz.gala.testing.testdata.ExamTestData.*;
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

        int userId = EXAM1.getUserId() + 1 ;
        int questionId = EXAM1.getQuestionId();

        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Not found entity with id=[" +userId + ", " + questionId + "]");
        Exam e =service.get(questionId,userId);
    }

    @Test
    public void testUpdateNotFound() {

        int questionId = EXAM1.getQuestionId();
        int userId = EXAM1.getUserId() + 1;
        int answerId = questionService.get(questionId).getRightAnswerId();

        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Not found entity with id=[" +userId + ", " + questionId + "]");
        service.update(new Exam(questionId, userId, null), answerId, userId);
    }


    @Test
    public void testUpdate() throws Exception {
        int questionId = EXAM1.getQuestionId();
        int userId = EXAM1.getUserId();
        int answerId = questionService.get(questionId).getRightAnswerId();
        service.update(EXAM1, answerId, userId);
        EXAM1.setUserAnswerId(answerId);
        MATCHER.assertEquals(EXAM1, service.get(questionId,userId));
    }

}