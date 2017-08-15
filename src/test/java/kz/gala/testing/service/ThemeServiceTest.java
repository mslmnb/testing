package kz.gala.testing.service;

import kz.gala.testing.model.Theme;
import kz.gala.testing.util.exception.NotFoundException;
import javax.validation.ConstraintViolationException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static kz.gala.testing.testdata.ThemeTestData.*;

public class ThemeServiceTest extends AbstractServiceTest{

    @Autowired
    private ThemeService service;

    @Before
    public void setUp() throws Exception {
        service.evictCache();
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(THEME1_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(THEME2,THEME3,THEME4,THEME5,THEME6,THEME7,THEME8,THEME9,THEME10),service.getAll());
    }

    @Test
    public void testDeleteNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Not found entity with id="+(THEME1_ID-1));
        service.delete(THEME1_ID-1);
    }

    @Test
    public void testGet() throws Exception {
        MATCHER.assertEquals(THEME1, service.get(THEME1_ID));
    }

    @Test
    public void testGetNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Not found entity with id="+(THEME1_ID-1));
        service.get(THEME1_ID-1);
    }

    @Test
    public void testSave() {
        Theme newTheme = new Theme(null, "Новая тема");
        service.save(newTheme);
        MATCHER.assertCollectionEquals(Arrays.asList(THEME1,THEME2,THEME3,THEME4,THEME5,THEME6,THEME7,THEME8,THEME9,THEME10,newTheme),service.getAll());
    }

    @Test
    public void testUpdate() {
        Theme updatedTheme = new Theme(THEME1_ID,"Обновленная тема");
        service.update(updatedTheme);
        MATCHER.assertEquals(updatedTheme, service.get(THEME1_ID));
    }

    @Test
    public void testUpdateNotFound() {
        //thrown.expect(NotFoundException.class);
        //thrown.expectMessage("Not found entity with id="+(THEME1_ID-1));
        Theme updatedTheme = new Theme(THEME1_ID-1,"Обновленная тема");
        service.update(updatedTheme);
    }

    @Test
    public void testGetAll() {
        MATCHER.assertCollectionEquals(Arrays.asList(THEME1,THEME2,THEME3,THEME4,THEME5,THEME6,THEME7,THEME8,THEME9,THEME10),service.getAll());
    }

    @Test
    public void testValidation() throws  Exception {
        validateRootCause(()->service.save(new Theme(null," ")), ConstraintViolationException.class);
    }
}

