package kz.gala.testing.web;

import org.junit.Test;

import static kz.gala.testing.TestUtil.userAuth;
import static kz.gala.testing.testdata.UserTestData.USER;
import static kz.gala.testing.testdata.UserTestData.USER_ID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class UserControllerTest extends AbstractControllerTest {

    @Test
    public void testGetProfile() throws Exception {
        mockMvc.perform(get("/user/profile")
                .with(userAuth(USER)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("profile"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/profile.jsp"));
    }

    @Test
    public void testPostProfile() throws Exception {
        mockMvc.perform(post("/user/profile")
                .param("id", Integer.toString(USER_ID))
                .param("name", "Корректировка имени пользователя")
                .param("position", "Корректировка дложности пользователя")
                .param("department", "Корректировка подразделения пользователя")
                .with(userAuth(USER)))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/exam"));

    }
}
