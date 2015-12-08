package edu.capital.csdb.models.DAO;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author kevinholland
 */
public class DataSourceFactory {
    public static DataSource initDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        Properties props = new Properties();
        InputStream is;
        try {
            is = DataSourceFactory.class.getClassLoader().getResourceAsStream("db.properties");
            props.load(is);
            dataSource.setDriverClassName(props.getProperty("DB_DRIVER_CLASS"));
            dataSource.setUrl(props.getProperty("DB_URL"));
            dataSource.setUsername(props.getProperty("DB_USERNAME"));
            dataSource.setPassword(props.getProperty("DB_PASSWORD"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    public static DataSource getDataSource() {
        try {
            Context context = new InitialContext();
            //The JDBC Data source that we just created
            return (DataSource) context.lookup("pool");
        } catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
