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
    /**
     * 删除视频
     */

    /**
     * 新增视频
     * 现在还没做上传功能，都是对象直接存到数据库，在所有功能做完后在做上传
     * @param videoEntity
     * @return
     */
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

    /**
     * 分页查询所有的视频
     * @param pn
     * @param size
     * @return
     */
    @GetMapping("/allVideo")
    public Result allVideo(@RequestParam() Integer pn,
                           @RequestParam() Integer size){
        System.out.println(pn +"   " + size);
        if (pn<=0 || size ==0){
            return result.error(ResultEnum.ERROR_INQUIRE);
        }else {
            result = videoService.getAllVideo(pn,size);
            System.out.println(result);
            return result;
        }
    }
    @DeleteMapping("/{id}")
    public Result deleteVideoId(@PathVariable Integer id){
        Result ok = videoService.deleteVideoId(id);
        return ok;
    }

}
