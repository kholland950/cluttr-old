package edu.capital.csdb;

import edu.capital.csdb.models.DAO.DataSourceFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author kevinholland
 */
public class AppInit implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Context ctx = null;
        try {
            ctx = new InitialContext();
            ctx.bind("pool", DataSourceFactory.initDataSource());
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
