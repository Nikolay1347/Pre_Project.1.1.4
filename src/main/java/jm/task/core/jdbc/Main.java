package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Util.getConnection();

        UserDao userDao = new UserDaoJDBCImpl();


        userDao.saveUser("Иван", "Соколов", (byte) 20);
        userDao.saveUser("Артём", "Федоров", (byte) 24);
        userDao.saveUser("Яна", "Иванова", (byte) 32);
        userDao.saveUser("Милана", "Князева", (byte) 27);

        userDao.removeUserById(2);
        userDao.getAllUsers();
        userDao.cleanUsersTable();

    }
}
