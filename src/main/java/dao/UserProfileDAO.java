package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.UserProfile;
import util.HibernateSessionFactory;

public class UserProfileDAO {

	private static final Logger log = LoggerFactory.getLogger(UserProfileDAO.class);

	private static final String NAME = "name";
	private static final String DOB = "dob";
	private static final String ADDRESS = "address";
	private static final String AGE = "age";

	Session session = HibernateSessionFactory.getSession();
	public UserProfile findById(java.lang.Integer id) {
		log.debug("getting UserProfile instance with id: " + id);
		try {
			UserProfile instance = (UserProfile) session.get("pojo.UserProfile", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
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
	public List<UserProfile> findByName(Object name){
		return findByProperty(NAME, name);
	}
	public List<UserProfile> findByDOB(Object dob){
		return findByProperty(DOB, dob);
	}
	public List<UserProfile> findByAddress(Object address){
		return findByProperty(ADDRESS, address);
	}
//	public List<UserProfile> findByAge(Object age){
//		return findByProperty(propertyName, value)
//	}
}
