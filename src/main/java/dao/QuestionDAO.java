package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.Question;
import util.HibernateSessionFactory;

public class QuestionDAO {
	private static final Logger log = LoggerFactory.getLogger(QuestionDAO.class);

	public static final String TEXT = "text";
	public static final String TIME = "time";
	public static final String MARKS = "marks";
	public static final String ISATTEMPTED = "isAttempted";

	Session session = HibernateSessionFactory.getSession();
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Question instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Question as model where model." + propertyName + "= ?";
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
	public Question findById(java.lang.Integer id) {
		log.debug("getting Question instance with id: " + id);
		try {
			Question instance = (Question) session.get("pojo.Question", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public List<Question> findByText(Object text) {
		return findByProperty(TEXT, text);
	}

	public List<Question> findByTime(Object time) {
		return findByProperty(TIME,time);
	}

	public List<Question> findByMarks(Object marks) {
		return findByProperty(MARKS, marks);
	}
	public List<Question> findByIsAttempted(Object isAttempted) {
		return findByProperty(ISATTEMPTED, isAttempted);
	}
	
}
