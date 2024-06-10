package com.candidate.verification.service;

import com.candidate.verification.config.DataSourceConfig;
import com.candidate.verification.config.DataSourceConfig.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.candidate.verification.util.DataSourceUtil.createDataSource;

@Service
public class UserService {

    @Autowired
    private DataSourceConfig config;

    public List<Map<String, Object>> aggregateUserData() {
        List<Map<String, Object>> results = new ArrayList<>();
        for (Database db : config.getDataSources()) {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(createDataSource(db));
            List<Map<String, Object>> queryResults = jdbcTemplate.queryForList("SELECT * FROM " + db.getTable());
            results.addAll(queryResults);
        }
        return results;
    }
}

