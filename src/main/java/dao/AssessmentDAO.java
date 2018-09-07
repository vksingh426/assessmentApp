package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.Assessment;
import pojo.User;
import util.HibernateSessionFactory;

public class AssessmentDAO {
	private static final Logger log = LoggerFactory.getLogger(AssessmentDAO.class);

	public static final String ROLE = "role";
	public static final String TITLE = "title";
	public static final String DATE = "date";
	public static final String DESCRIPTION="description";

	Session session = HibernateSessionFactory.getSession();
	public Assessment findById(java.lang.Integer id) {
		log.debug("getting Assessment instance with id: " + id);
		try {
			Assessment instance = (Assessment) session.get("pojo.Assessment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public List<Assessment> findByRole(Object role) {
		return findByProperty(ROLE, role);
	}
	public List<Assessment> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}
	public List<Assessment> findByDate(Object date) {
		return findByProperty(DATE, date);
	}
	public List<User> findByDescription (Object description) {
		return findByProperty(DESCRIPTION, description);
	}
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
}
