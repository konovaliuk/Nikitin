package com.peregrine.getfit.util;

import com.peregrine.getfit.dao.MySqlDAOFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.ResourceBundle;

/**
 * Класс для получения Connection'a
 */
public class DataSourceManager {
    private static Logger logger = LogManager.getLogger(MySqlDAOFactory.class.getName());
    private static BasicDataSource dataSource;
    private static ResourceBundle resource;
    private static final String BUNDLE_NAME = "connection";

    public static BasicDataSource data() {
        logger.info("beginning to establish connection");
        resource = ResourceBundle.getBundle(BUNDLE_NAME);

        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(resource.getString("driver"));
        dataSource.setUrl(resource.getString("url"));
        dataSource.setUsername(resource.getString("userName"));
        dataSource.setPassword(resource.getString("password"));

        dataSource.setMaxIdle(Integer.parseInt(resource.getString("maxIdle")));
        dataSource.setMaxWaitMillis(Integer.parseInt(resource.getString("maxWait")));
        return dataSource;
    }
}
