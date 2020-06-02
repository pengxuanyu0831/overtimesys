package com.xuanyu.dao;
import com.xuanyu.dao.UserMapper;
import com.xuanyu.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;

public class mybatistest {
    /**
     * 测试查询用户
     * @throws Exception
     */
    @Test
    public void run1() throws Exception {
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        UserMapper dao = session.getMapper(UserMapper.class);
        // 查询所有数据
        List<User> list = dao.findUsers();
        for(User user : list){
            System.out.println(user);
        }
        // 关闭资源
        session.close();
        in.close();
    }

    /**
     * 测试注册
     * @throws Exception
     */
    @Test
    public void run2() throws Exception {
        User user = new User();
        user.setName("threestar");
        user.setPassword("789");
        user.setEmail("34343@qq.com");

        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        UserMapper dao = session.getMapper(UserMapper.class);

        // 保存
        dao.insertUser(user);

        // 提交事务
        session.commit();

        // 关闭资源
        session.close();
        in.close();
    }
}