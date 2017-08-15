package kz.gala.testing.web;

import org.junit.Test;

import static kz.gala.testing.TestUtil.userAuth;
import static kz.gala.testing.testdata.UserTestData.ADMIN;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AdminControllerTest extends AbstractControllerTest{

    @Test
    public void testExam() throws Exception {
        mockMvc.perform(get("/ajax/admin/themes")
                .with(userAuth(ADMIN)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
