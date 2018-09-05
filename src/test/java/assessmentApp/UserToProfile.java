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

			for (int i = 0; i < 100; i++) {
		
			User user = new User();
			UserProfile userProfile = new UserProfile(faker.name().name(),
					faker.number().numberBetween(1996, 2018) + "", faker.number().numberBetween(10, 50),
					faker.address().fullAddress(), user);
			user.setEmail(faker.internet().emailAddress());
			user.setPassword(faker.internet().password());
			user.setProfile(userProfile);
			session.save(user);
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("Done");
		System.exit(0);
	}

}
