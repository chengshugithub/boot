package com.example.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.boot.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;



/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author astupidcoder
 * @since 2020-05-13
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
//     List<User> usersFuzzyQuery(@Param("user") User user, @Param("current") Integer current);
     User getUserByUserName(@Param("username")String username);

}

