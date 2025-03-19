package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static final UserDao JDBC = new UserDaoJDBCImpl();
    private static final UserDao Hibernate = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {

        Hibernate.createUsersTable();
    }

    @Override
    public void dropUsersTable() {

        Hibernate.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        Hibernate.saveUser(name,lastName,age);
    }
    @Override
    public void removeUserById(long id) {

        Hibernate.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {

        return Hibernate.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {

        Hibernate.cleanUsersTable();
    }
}
