package edu.capital.csdb.models.DAO;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Abstract Data Access Object class
 */
public abstract class DAO {
    protected DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;

    public DAO(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        updateJDBCTemplate();
    }

    public void updateJDBCTemplate() {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}