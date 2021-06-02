package com.yiben_video.web;

import com.alibaba.fastjson.JSONObject;
import com.yiben_video.common.Result;
import com.yiben_video.common.ResultEnum;
import com.yiben_video.pojo.VideoEntity;
import com.yiben_video.service.VideoService;
import com.yiben_video.utils.Time;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 王飞
 * @create 2021/5/31 13:52
 * @emai 936886169@qq.com
 */
@Slf4j
@RestController
@Api(tags = "视频管理")
@RequestMapping("/video")
public class VideoController extends BaseController{
    Result result = new Result();
    /**
     * 根据id查询视频
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getFindVideo(
            @PathVariable("id") Integer id
    ){
        Result idVideo = videoService.getFindOneVideo(id);
        return idVideo;
    }

    @PostMapping("/saveVideo")
    public Result saveVideo(
            VideoEntity videoEntity
    ){
        VideoEntity videoEntity1 = new VideoEntity();
        videoEntity1.setVideoName(videoEntity.getVideoName());
        videoEntity1.setVideoUrl(videoEntity.getVideoUrl());
        videoEntity1.setUploadTime(Time.sqlData());
        videoService.saveVideo(videoEntity1);
        return  result.success(ResultEnum.SUCCESS);

    }

    @GetMapping("/allVideo")
    public Result allVideo(){
        System.out.println(videoService.allVideo());
        return result.success(ResultEnum.SUCCESS,videoService.allVideo());
    }

}
