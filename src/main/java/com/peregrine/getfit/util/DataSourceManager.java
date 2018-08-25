package com.peregrine.getfit.util;

import com.peregrine.getfit.dao.MySqlDAOFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DataSourceManager {
    private static Logger logger = LogManager.getLogger(MySqlDAOFactory.class.getName());

    public static DataSource data() {
        logger.info("beginning to establish connection");

        InitialContext initialContext = null;
        DataSource dataSource = null;
        try {
            initialContext = new InitialContext();
            dataSource = (DataSource)initialContext.lookup("java:comp/env/getfit");
            return dataSource;
        }
        catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
