package nuc.ss.dao;

import java.util.List;
import nuc.ss.pojo.User;
import nuc.ss.utils.MybatisUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/9/22 17:05
 */
public class ExecutorTest {

    @Test
    public void simpleExecutorTest() {
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        for (int i = 0; i < 2; i++) {
            List<User> userList = userMapper.getUserList();
            System.out.println(userList.get(0));
        }

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void reuseExecutorTest() {
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession(ExecutorType.REUSE);

        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        for (int i = 0; i < 2; i++) {
            List<User> userList = userMapper.getUserList();
            System.out.println(userList.get(0));
        }

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void batchExecutorTest() {

    }
}
