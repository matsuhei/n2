package main.doma.dao;

import main.config.AppConfig;
import main.doma.entity.Log;
import org.seasar.doma.BatchInsert;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao(config = AppConfig.class)
@ConfigAutowireable
public interface LogDao {

    @Select
    List<Log> selectAll();

    @Select
    Log selectById(Long id);

    @Select
    List<Log> selectByIds(List<Long> ids);

    @Select
    Log selectByName(String name);

    @Select
    Log selectByParamA(String paramA);

    @Select
    Log selectByParamB(String paramB);

    @Insert
    int insert(Log log);

    @BatchInsert
    int[] bulkInsert(List<Log> logs);
}
