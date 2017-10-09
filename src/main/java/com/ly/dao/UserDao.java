package com.ly.dao;

import com.ly.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ly on 2017/10/8 18:06
 */
@Repository
public interface UserDao {
    User getUserByName(@Param("username") String username, @Param("password") String password);
    
    void register(User user);
}
