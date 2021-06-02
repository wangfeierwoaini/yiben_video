package com.yiben_video.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yiben_video.dao.VideoDao;
import com.yiben_video.pojo.VideoEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 王飞
 * @create 2021/6/2 14:20
 * @emai 936886169@qq.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class VideoServiceImplTest {

    @Resource
    VideoDao videoDao;
    @Test
    void allVideo() {
        List<VideoEntity> list = videoDao.findAll();
        String l = JSONObject.toJSONString(list);
        System.out.println(l);
    }
}