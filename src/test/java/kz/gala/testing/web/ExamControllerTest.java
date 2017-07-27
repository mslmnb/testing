package kz.gala.testing.web;

import org.junit.Test;

import static kz.gala.testing.TestUtil.userAuth;
import static kz.gala.testing.testdata.UserTestData.USER;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by Mussulmanbekova_GE on 27.07.2017.
 */
public class ExamControllerTest extends AbstractControllerTest {

    @Test
    public void testExam() throws Exception {
        mockMvc.perform(get("/exam")
                .with(userAuth(USER)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("exam"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/exam.jsp"));
    }

    @Test
    public void testExamReport() throws Exception {
        mockMvc.perform(get("/exam/report")
                .with(userAuth(USER)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("report"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/report.jsp"));
    }

}
