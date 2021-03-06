package com.yiben_video.dao;

import com.yiben_video.pojo.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author ηι£
 * @create 27/5/2021 δΈε3:24
 * @emai 936886169@qq.com
 */
public interface UserDao extends JpaSpecificationExecutor<UserEntity>,
        JpaRepository<UserEntity,Integer>,
        PagingAndSortingRepository<UserEntity,Integer> {
    @Query(value = "SELECT * FROM usertable WHERE username = :username", nativeQuery = true)
    UserEntity findByUsername(String username);
}
