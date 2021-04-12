package main.service;

import main.doma.dao.LogDao;
import main.doma.entity.Log;
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
public class LogServiceTest {
    @Autowired
    LogDao logDao;

    @Test
    public void indexTest() {
        init();
        logDao.selectAll();

        // 複合Indexの確認

        // paramA
        Long timeByParamAStart = new Timestamp(System.currentTimeMillis()).getTime();
        Log logByParamA = logDao.selectByParamA("A100");
        Long timeByParamAEnd = new Timestamp(System.currentTimeMillis()).getTime();
        Long resultParamA = timeByParamAEnd - timeByParamAStart;
        System.out.println("複合Indexが効く単体取得(ms): " + resultParamA.toString());

        // paramB
        Long timeByParamBStart = new Timestamp(System.currentTimeMillis()).getTime();
        Log logByParamB = logDao.selectByParamB("B100");
        Long timeByParamBEnd = new Timestamp(System.currentTimeMillis()).getTime();
        Long resultParamB = timeByParamBEnd - timeByParamBStart;
        System.out.println("複合Indexが効かない単体取得(ms): " + resultParamB.toString());
    }

    private void init() {
        List<Log> list = new ArrayList<>();
        for (long i = 1; i < 10000; i++) {
            list.add(
                Log.builder()
                    .id(i)
                    .name("test" + i)
                    .parama("A" + i)
                    .paramb("B" + i)
                    .build()
            );
        }
        logDao.bulkInsert(list);
    }
}
