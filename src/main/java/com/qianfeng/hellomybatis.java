package com.qianfeng;

import com.qianfeng.dao.UserMapper;
import com.qianfeng.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class hellomybatis {
    public static void main(String[] args) {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

            // 2. 获取SqlSessionFactory
            // 工厂，生产一个SqlSession
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            // 3. 获取SqlSession
            // openSession参数: true: 自动提交事务; false: 手动提交事务
            // 使用无参方法的话，默认为true
            SqlSession sqlSession = sqlSessionFactory.openSession();

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List list = mapper.quaryAll();
            User user = mapper.quaryById(7);
            User user1 = mapper.quaryById(10);

            System.out.println(list);
            System.out.println(user);
            System.out.println(user1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
