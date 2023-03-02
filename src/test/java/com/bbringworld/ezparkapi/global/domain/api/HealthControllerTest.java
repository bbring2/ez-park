package com.bbringworld.ezparkapi.global.domain.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(HealthController.class)
@ExtendWith(SpringExtension.class)
class HealthControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser
    void hello_return() throws Exception {
        String hello = "This is health check tho :)";

        mvc.perform(get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk()) //status검증
                .andExpect(content().string(hello))
                .andDo(print()); //내용 검증
    }

}

