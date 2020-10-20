package com.qianfeng.dao;

import com.qianfeng.domain.User;

import java.util.List;

public interface UserMapper {
    User quaryById(int id);
    List<User> quaryAll();
}
