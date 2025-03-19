package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;



public class UserDaoHibernateImpl implements UserDao {


    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {

        String sql = "CREATE TABLE IF NOT EXISTS User (id INT NOT NULL AUTO_INCREMENT, name CHAR(20) NOT NULL, " +
                "lastName CHAR(20), age INT (3), PRIMARY KEY (id))";

        try (Session session = Util.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String sql = "DROP TABLE IF EXISTS User";
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name,lastName,age);
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }


    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            User user = session.get(User.class, id);
            Transaction transaction = session.beginTransaction();
            session.remove(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        try (Session session = Util.getSessionFactory().openSession()) {
            result = session.createQuery("from User ", User.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User");
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
