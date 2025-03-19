package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Util {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/preproject.1.1.4";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "admin";

    private static SessionFactory sessionFactory;


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Class.forName(DB_DRIVER);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


   // private static SessionFactory sessionFactory;
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            try {
//                Configuration configuration = new Configuration();
//
//                // Hibernate settings equivalent to hibernate.cfg.xml's properties
//                Properties settings = new Properties();
//                settings.put(Environment.DRIVER, DB_DRIVER);
//                settings.put(Environment.URL, DB_URL);
//                settings.put(Environment.USER, DB_USERNAME);
//                settings.put(Environment.PASS, DB_PASSWORD);
//                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
//
//               // settings.put(Environment.SHOW_SQL, "true");
//
//                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//
//               // settings.put(Environment.HBM2DDL_AUTO, "create-drop");
//
//                configuration.setProperties(settings);
//
//                configuration.addAnnotatedClass(User.class);
//
//                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                        .applySettings(configuration.getProperties()).build();
//
//                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return sessionFactory;
//    }


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.setProperty(Environment.DRIVER, DB_DRIVER);
                settings.setProperty(Environment.URL, DB_URL);
                settings.setProperty(Environment.USER, DB_USERNAME);
                settings.setProperty(Environment.PASS, DB_PASSWORD);

               // settings.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

               // settings.setProperty(Environment.SHOW_SQL, "true");
               // settings.setProperty("hibernate.format_sql", "true");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);


                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
