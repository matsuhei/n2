package main.doma.dao;

import main.config.AppConfig;
import main.doma.entity.User;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao(config = AppConfig.class)
@ConfigAutowireable
public interface UserDao {

    @Select
    List<User> selectAll();

    @Select
    User selectById(Long id);

    @Select
    List<User> selectByIds(List<Long> ids);

    @Select
    User selectByName(String name);

    @Select
    User selectByParamA(String paramA);

    @Insert
    int insert(User user);

    @BatchInsert
    int[] bulkInsert(List<User> user);
}
