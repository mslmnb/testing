package kz.gala.testing.service;

import kz.gala.testing.model.Question;
import kz.gala.testing.util.exception.NotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static kz.gala.testing.testdata.QuestionTestData.*;
import static kz.gala.testing.testdata.ThemeTestData.THEME1_ID;

public class QuestionServiceTest extends AbstractServiceTest {

    @Autowired
    private QuestionService service;

    @Test
    public void testGet() throws Exception {
        MATCHER.assertEquals(QUESTION1, service.get(QUESTION1_ID, THEME1_ID));
    }

    @Test
    public void testGetNotFound() {
        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Not found entity with id="+(QUESTION1_ID - 1));
        service.get(QUESTION1_ID - 1, THEME1_ID);
    }

    @Test
    public void testGetAll() {
        MATCHER.assertCollectionEquals(
                Arrays.asList(QUESTION1,QUESTION2,QUESTION3,QUESTION4,QUESTION5,QUESTION6,QUESTION7,QUESTION8,QUESTION9),
                service.getAll(THEME1_ID)
        );

    }

    @Test
    public void testDelete() throws Exception {
        service.delete(QUESTION1_ID, THEME1_ID);
        MATCHER.assertCollectionEquals(
                Arrays.asList(QUESTION2,QUESTION3,QUESTION4,QUESTION5,QUESTION6,QUESTION7,QUESTION8,QUESTION9),
                service.getAll(THEME1_ID)
        );

    }

    @Test
    public void testDeleteNotFound() {
        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Not found entity with id=" + (QUESTION1_ID - 1));
        service.delete(QUESTION1_ID - 1, THEME1_ID);
    }


    @Test
    public void testSave() throws Exception {
        Question created = getCreated();
        service.save(created, THEME1_ID);
    }

}
