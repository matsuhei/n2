package main.doma;


import main.doma.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.selectAll();
    }

    public User findById(Long id) {
        return userDao.selectById(id);
    }
}
