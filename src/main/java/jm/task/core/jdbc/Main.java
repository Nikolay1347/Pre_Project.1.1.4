package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserDao JDBC = new UserDaoJDBCImpl();
        UserDao Hibernate = new UserDaoHibernateImpl();

        Hibernate.createUsersTable();

        Hibernate.saveUser("Иван", "Соколов", (byte) 20);
        Hibernate.saveUser("Артём", "Федоров", (byte) 24);
        Hibernate.saveUser("Яна", "Иванова", (byte) 32);
        Hibernate.saveUser("Милана", "Князева", (byte) 27);

        Hibernate.removeUserById(2);

        System.out.println(Hibernate.getAllUsers());

        Hibernate.cleanUsersTable();


        Hibernate.dropUsersTable();
    }
}
