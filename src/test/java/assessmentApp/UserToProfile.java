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

		try {
			session.getTransaction().begin();
			for (int i = 0; i < 10; i++) {

				User user = new User();
				user.setEmail(faker.internet().emailAddress());
				user.setPassword(faker.internet().password());
				
				UserProfile userProfile = new UserProfile();
				userProfile.setName(faker.name().name());
				userProfile.setDOB(faker.number().numberBetween(1996, 2018) + "");
				userProfile.setAge(faker.number().numberBetween(10, 50));
				userProfile.setAddress(faker.address().fullAddress());
				userProfile.setUser(user);
				user.setProfile(userProfile);
				session.save(user);
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("Done");
		System.exit(0);
	}

}
