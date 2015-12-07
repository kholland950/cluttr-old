package edu.capital.csdb.models.DAO;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author kevinholland
 */
public class DataSourceFactory {
    public static DataSource getDataSource() {
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
}
