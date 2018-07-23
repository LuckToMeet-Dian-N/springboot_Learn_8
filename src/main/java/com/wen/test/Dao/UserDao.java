package com.wen.test.Dao;

import com.wen.test.vo.Users;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@CacheConfig(cacheNames = "users")
public interface UserDao extends JpaRepository<Users,Integer>{


    @Cacheable(key ="'id:'+#p0")
    @Query("select u from Users u where u.user_id=:user_id")
    Users findUsersByUser_id(@Param("user_id") Integer user_id);

    @Modifying
    @Transactional
//    @CachePut(key = "'id:'+#p0.user_id")  //缓存刷新
    @CacheEvict(key = "'id:'+#p0.user_id") //删除缓存
    Users save(Users users);

}
