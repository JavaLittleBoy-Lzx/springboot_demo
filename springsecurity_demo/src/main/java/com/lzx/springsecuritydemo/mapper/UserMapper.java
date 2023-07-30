package com.lzx.springsecuritydemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzx.springsecuritydemo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author lzx
 * @Date 2023/7/29 8:48:26
 * @Version 1.0
 **/
@Repository
public interface UserMapper extends BaseMapper<User> {
}
