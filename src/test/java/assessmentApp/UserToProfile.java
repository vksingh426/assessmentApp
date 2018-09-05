package assessmentApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.github.javafaker.Faker;
import pojo.User;
import pojo.UserProfile;
import util.HibernateSessionFactory;

public class UserToProfile {

	public static void main(String[] args) {

		Faker faker = new Faker();
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			UserProfile userProfile = new UserProfile(faker.name().name(),
					faker.number().numberBetween(1996, 2018) + "", faker.number().numberBetween(10, 50),
					faker.address().fullAddress());
			User user = new User(faker.internet().emailAddress(), faker.internet().password(), userProfile);
			session.save(user);
			session.save(userProfile);
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
