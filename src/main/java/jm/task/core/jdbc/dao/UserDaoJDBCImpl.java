package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {

    private static long id;


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS User (id CHAR(5), name CHAR(20) NOT NULL, " +
                "lastName CHAR(20), age CHAR(3), PRIMARY KEY (id))";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();) {
            statement.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS User";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO User (id, name, lastName, age) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, ++id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, lastName);
            preparedStatement.setByte(4, age);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById (long id) {
        String sql = "DELETE FROM User WHERE id = " + id;
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        String sql = "SELECT id, name, lastName, age FROM User";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(Long.valueOf(resultSet.getString("id")));
                user.setName(resultSet.getString("Name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(Byte.valueOf(resultSet.getString("age")));
                result.add(user);
                System.out.println(user.toString());
                }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void cleanUsersTable() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate("DELETE FROM User");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
