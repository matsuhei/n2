package main.service;

import main.doma.dao.UserDao;
import main.doma.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.doma.internal.util.AssertionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;

    @Test
    public void indexTest() {
        init();
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
    public void selectIds() {
        init();

        List<Long> ids = new ArrayList<>();
        for (long i = 3; i < 10000; i = i + 3) {
            ids.add(i);
        }

        userDao.selectAll();

        // select 単体ずつ
        Long timeByIdStart = new Timestamp(System.currentTimeMillis()).getTime();
        List<User> userListId = new ArrayList<>();
        ids.forEach(id -> {
            userListId.add(userDao.selectById(id));
        });
        Long timeByIdEnd = new Timestamp(System.currentTimeMillis()).getTime();
        Long resultById = timeByIdEnd - timeByIdStart;
        System.out.println("select複数 それぞれの取得(ms): " + resultById.toString());

        // select 複数 In句
        Long timeByIdsStart = new Timestamp(System.currentTimeMillis()).getTime();
        List<User> userListIds = userDao.selectByIds(ids);
        Long timeByIdsEnd = new Timestamp(System.currentTimeMillis()).getTime();
        Long resultByIds = timeByIdsEnd - timeByIdsStart;
        System.out.println("select複数 In句の取得(ms): " + resultByIds.toString());

    }

    private void init() {
        List<User> list = new ArrayList<>();
        for (long i = 1; i < 10000; i++) {
            list.add(
                User.builder()
                    .id(i)
                    .name("test" + i)
                    .parama("A" + i)
                    .paramb("B" + i)
                    .build()
            );
        }
        userDao.bulkInsert(list);
    }
}
