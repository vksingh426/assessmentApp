package dao;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.Question;
import util.HibernateSessionFactory;

public class QuestionDAO {
	private static final Logger log = LoggerFactory.getLogger(QuestionDAO.class);

	private static final String NAME = "name";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";

	Session session = HibernateSessionFactory.getSession();
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
}
