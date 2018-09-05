package dao;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.Result;
import util.HibernateSessionFactory;

public class ResultDAO {
	private static final Logger log = LoggerFactory.getLogger(ResultDAO.class);

	private static final String NAME = "name";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";

	Session session = HibernateSessionFactory.getSession();
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

}
