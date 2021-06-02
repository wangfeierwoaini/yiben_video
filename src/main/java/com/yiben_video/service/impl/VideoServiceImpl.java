package com.yiben_video.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yiben_video.common.Result;
import com.yiben_video.common.ResultEnum;
import com.yiben_video.pojo.VideoEntity;
import com.yiben_video.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 王飞
 * @create 27/5/2021 下午3:59
 * @emai 936886169@qq.com
 */
@Service
public class VideoServiceImpl extends BaseServiceImpl implements VideoService {
    Result result = new Result();
    private List<Integer> get() {
        List<VideoEntity> user = videoDao.findAll();
        List<Integer> videoID = user.stream().map(VideoEntity::getId).collect(Collectors.toList());
        return videoID;
    }

    /**
     * 根据id查询视频（修改）
     * @param id
     * @return
     */
    @Override
    public Result getFindOneVideo(Integer id) {
        if (!get().contains(id)){
            return result.error(ResultEnum.ERROR_NOT_VIDEO);
        }else {
            VideoEntity videoEntity = videoDao.findById(id).get();
            return result.success(ResultEnum.SUCCESS_INQUIRE,videoEntity);
        }
    }

    @Override
    public void saveVideo(VideoEntity videoEntity1) {
        videoDao.save(videoEntity1);
    }

    @Override
    public String allVideo() {
        List<VideoEntity> list = videoDao.findAll();
        String l = JSONObject.toJSONString(list);
        return l;
    }


}
