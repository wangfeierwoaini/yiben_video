package com.yiben_video.dao;

import com.yiben_video.pojo.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author 王飞
 * @create 27/5/2021 下午3:37
 * @emai 936886169@qq.com
 */
public interface VideoDao extends JpaSpecificationExecutor<VideoEntity>,
        JpaRepository<VideoEntity,Integer>,
        PagingAndSortingRepository<VideoEntity,Integer> {
}
