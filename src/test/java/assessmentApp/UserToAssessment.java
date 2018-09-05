package assessmentApp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

			User user = new User();
			user.setEmail(faker.internet().emailAddress());
			user.setPassword(faker.internet().password());
			
			Set<Assessment> list = new HashSet<>();
			Assessment assessment = new Assessment();
			assessment.setRole("role");
			assessment.setTitle("title");
			assessment.setDate(null);
			assessment.setDescription("description");
			assessment.setUser(user);
			list.add(assessment);
			
			user.setAssessments(list);
			session.save(user);
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
