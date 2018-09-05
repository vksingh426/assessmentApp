package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.Options;
import pojo.User;
import util.HibernateSessionFactory;

public class OptionsDAO {
	private static final Logger log = LoggerFactory.getLogger(OptionsDAO.class);

	private static final String TEXT = "text";
	
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
	
		public Options findById(java.lang.Integer id) {
		log.debug("getting Options instance with id: " + id);
		try {
			Options instance = (Options) session.get("pojo.Options", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public List<Options> findByText(Object text){
		return findByProperty(TEXT,text);
	}
	
}
