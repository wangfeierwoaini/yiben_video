package com.yiben_video.service;

import com.yiben_video.common.Result;
import com.yiben_video.pojo.VideoEntity;

import java.util.List;

/**
 * @author ηι£
 * @create 27/5/2021 δΈε3:57
 * @emai 936886169@qq.com
 */
public interface VideoService {
    Result getFindOneVideo(Integer id);


    void saveVideo(VideoEntity videoEntity1);


    List<VideoEntity> allVideo();


    Result getAllVideo(Integer pn, Integer size);

    Result deleteVideoId(Integer id);
}
