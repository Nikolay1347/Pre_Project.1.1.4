package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static final UserDao JDBC = new UserDaoJDBCImpl();
    private static final UserDao HIBERNATE = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {

        HIBERNATE.createUsersTable();
    }

    @Override
    public void dropUsersTable() {

        HIBERNATE.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        HIBERNATE.saveUser(name,lastName,age);
    }
    @Override
    public void removeUserById(long id) {

        HIBERNATE.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {

        return HIBERNATE.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {

        HIBERNATE.cleanUsersTable();
    }
}
