package com.candidate.verification.util;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.candidate.verification.config.DataSourceConfig.Database;

public class DataSourceUtil {

    public static DataSource createDataSource(Database dbConfig) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(dbConfig.getUrl());
        dataSource.setUsername(dbConfig.getUser());
        dataSource.setPassword(dbConfig.getPassword());
        return dataSource;
    }

}
