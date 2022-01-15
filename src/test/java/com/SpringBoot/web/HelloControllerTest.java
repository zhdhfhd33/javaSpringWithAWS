package com.SpringBoot.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; //HTTP요청을 보내기 위한 객체

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello")) //HTTP GET요청을 실제로 보낸다.
                .andExpect(status().isOk())
                .andExpect(content().string(hello));


    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name ="hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))//string값만 허용된다. 숫자 날짜 전부 string으로 바꿔야 사용가능함.
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.name", is(name))) //hello/dto는 json을 반환하기 때문에 json을 검사하는 방법이 $와 함께 필드명을 사용하면 된다.
                        .andExpect(jsonPath("$.amount", is(amount)));
    }
}
