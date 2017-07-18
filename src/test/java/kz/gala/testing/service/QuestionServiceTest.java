package kz.gala.testing.service;

import kz.gala.testing.util.exception.NotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static kz.gala.testing.testdata.QuestionTestData.MATCHER;
import static kz.gala.testing.testdata.QuestionTestData.QUESTION1;
import static kz.gala.testing.testdata.QuestionTestData.QUESTION1_ID;

/**
 * Created by Mussulmanbekova_GE on 11.07.2017.
 */
public class QuestionServiceTest extends AbstractServiceTest {

    @Autowired
    private QuestionService service;

    @Test
    public void testGet() throws Exception {
        MATCHER.assertEquals(QUESTION1, service.get(QUESTION1_ID));
    }

    @Test
    public void testGetNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Not found entity with id="+(QUESTION1_ID - 1));
        service.get(QUESTION1_ID - 1);
    }
}
