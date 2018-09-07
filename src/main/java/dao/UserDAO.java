package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.User;
import util.HibernateSessionFactory;

public class UserDAO {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);

	public static final String NAME = "name";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";

	Session session = HibernateSessionFactory.getSession();
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from User as model where model." + propertyName + "= ?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	private Object getSession() {
		// TODO Auto-generated method stub
		return null;
	}
	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) session.get("pojo.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public List<User> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<User> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<User> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}
	
}
