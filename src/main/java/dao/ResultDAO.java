package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.Result;
import util.HibernateSessionFactory;

public class ResultDAO {
	private static final Logger log = LoggerFactory.getLogger(ResultDAO.class);

	public static final String DURATION = "duration";
	public static final String QUESTIONSATTEMPTED = "questionsAttempted";
	public static final String QUESTIONSNOTATTEMPTED = "questionsNotAttempted";
	public static final String MARKS = "marks";

	Session session = HibernateSessionFactory.getSession();

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Result instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Result as model where model." + propertyName + "= ?";
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

	public Result findById(java.lang.Integer id) {
		log.debug("getting Result instance with id: " + id);
		try {
			Result instance = (Result) session.get("pojo.Result", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Result> findByDuration(Object duration) {
		return findByProperty(DURATION, duration);
	}

	public List<Result> findByQuestionsAttempted(Object questionsAttempted) {
		return findByProperty(QUESTIONSATTEMPTED, questionsAttempted);
	}

	public List<Result> findByQuestionsNotAttempted(Object questionsNotAttempted) {
		return findByProperty(QUESTIONSNOTATTEMPTED, questionsNotAttempted);
	}

}
