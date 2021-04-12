package main.doma.repository;


import main.doma.dao.LogDao;
import main.doma.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogRepository {
    @Autowired
    private LogDao logDao;

    public List<Log> findAll() {
        return logDao.selectAll();
    }

    public Log findById(Long id) {
        return logDao.selectById(id);
    }

    public List<Log> findByIds(List<Long> ids) {
        return logDao.selectByIds(ids);
    }
}
