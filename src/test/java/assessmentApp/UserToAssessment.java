package assessmentApp;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.github.javafaker.Faker;
import pojo.Assessment;
import pojo.User;
import util.HibernateSessionFactory;

public class UserToAssessment {

	public static void main(String[] args) {

		Faker faker = new Faker();
		Session session = HibernateSessionFactory.getSession();

		try {
			session.getTransaction().begin();

			Set<Assessment> assessments = new HashSet<>();

			for (int i = 1; i <= 10; i++) {

				User user = new User();
				user.setEmail(faker.internet().emailAddress());
				user.setPassword(faker.internet().password());

				Assessment assessment = new Assessment();

				assessment.setRole(faker.number().randomDigitNotZero() + "");
				assessment.setTitle("Aptitude");
				assessment.setDate(faker.date() + "");
				assessment.setDescription("DSRFGUHJIKLCXVBNMRTYUIO");
				assessment.setUser(user);
				assessments.add(assessment);
				user.setAssessments(assessments);
				session.save(assessment);
				session.save(user);
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("Done");
	}

}
