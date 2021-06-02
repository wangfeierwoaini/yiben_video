package com.yiben_video.web;

import com.yiben_video.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author 王飞
 * @create 2021/6/2 13:38
 * @emai 936886169@qq.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class VideoControllerTest {
    private MockMvc mockMvc;

    @Test
    public void get() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/video/allVideo").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}