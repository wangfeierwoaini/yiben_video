package com.yiben_video.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author 王飞
 * @create 2021/5/31 15:08
 * @emai 936886169@qq.com
 */
@Entity
@Table(name = "videotable", schema = "video", catalog = "")
public class VideoEntity {
    private int id;
    private String videoName;
    private String videoUrl;
    private String videoEwm;
    private String uploadTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "video_name", nullable = false, length = 20)
    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    @Basic
    @Column(name = "video_url", nullable = true, length = 255)
    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Basic
    @Column(name = "video_ewm", nullable = true, length = 255)
    public String getVideoEwm() {
        return videoEwm;
    }

    public void setVideoEwm(String videoEwm) {
        this.videoEwm = videoEwm;
    }

    @Basic
    @Column(name = "upload_time", nullable = true)
    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoEntity that = (VideoEntity) o;
        return id == that.id && Objects.equals(videoName, that.videoName) && Objects.equals(videoUrl, that.videoUrl) && Objects.equals(videoEwm, that.videoEwm) && Objects.equals(uploadTime, that.uploadTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, videoName, videoUrl, videoEwm, uploadTime);
    }
}
