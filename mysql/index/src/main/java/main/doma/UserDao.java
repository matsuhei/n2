package main.doma;

import main.config.AppConfig;
import main.doma.entity.User;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
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
    User selectByName(String name);

    @Select
    User selectByParamA(String paramA);

    @Select
    int truncate();

    @Insert
    int insert(User user);

}
