package com.qianfeng;

import com.qianfeng.dao.UserMapper;
import com.qianfeng.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {
    private UserMapper userMapper;
    @Before
    public void  init() throws IOException {

        InputStream rs = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(rs);
        SqlSession sqlSession = build.openSession();
        userMapper= sqlSession.getMapper(UserMapper.class);
    }
    @Test
    public void quaryById(){
        User user = userMapper.quaryById(7);
        System.out.println(user);
    }
    @Test
    public void quaryAll(){
        List<User> users = userMapper.quaryAll();
        System.out.println(users);
    }
    @Test
    public void quary(){
        List<User> users = userMapper.quaryAll();
        System.out.println(users);
        User user = userMapper.quaryById(7);
        System.out.println(user);
        User user1 = userMapper.quaryById(10);
        System.out.println(user1);
    }
}
