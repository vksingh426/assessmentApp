package assessmentApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.github.javafaker.Faker;

import pojo.Assessment;
import pojo.User;
import pojo.UserProfile;
import util.HibernateSessionFactory;

public class UserToAssessment {
	
	public static void main(String[] args) {
		
		Faker faker = new Faker();
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			
			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		System.out.println("Done");
	}

}
