package main.service;

import main.doma.UserDao;
import main.doma.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.doma.internal.util.AssertionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;

    @Test
    public void insert() {
        long i;
        for (i = 1; i < 10000; i++) {
            userDao.insert(
                User.builder()
                    .id(i)
                    .name("test" + i)
                    .parama("A" + i)
                    .paramb("B" + i)
                    .build()
            );
        }

        userDao.selectAll();

        // インデックスを貼ってない かつ 引き出すケースが無いものは基本使わない
        Long timeByParamStart = new Timestamp(System.currentTimeMillis()).getTime();
        User userByParam = userDao.selectByParamA("A100");
        Long timeByParamEnd = new Timestamp(System.currentTimeMillis()).getTime();
        Long resultParam = timeByParamEnd - timeByParamStart;
        System.out.println("インデックスなしの単体取得(ms): " + resultParam.toString());

        // primary unique
        Long timeByIdStart = new Timestamp(System.currentTimeMillis()).getTime();
        User user = userDao.selectById(100L);
        Long timeByIdEnd = new Timestamp(System.currentTimeMillis()).getTime();
        Long resultId = timeByIdEnd - timeByIdStart;
        System.out.println("Primary Uniqueの単体取得(ms): " + resultId.toString());

        // index
        Long timeByNameStart = new Timestamp(System.currentTimeMillis()).getTime();
        User userByName = userDao.selectByName("test100");
        Long timeByNameEnd = new Timestamp(System.currentTimeMillis()).getTime();
        Long resultByName = timeByNameEnd - timeByNameStart;
        System.out.println("index の単体取得(ms): " + resultByName.toString());

        AssertionUtil.assertEquals(
            user,
            User.builder().id(100L).name("test100").parama("A100").paramb("B100").build()
        );
    }

    @Test
    public void test() {
        userService.getUserById(1L);
    }
}
