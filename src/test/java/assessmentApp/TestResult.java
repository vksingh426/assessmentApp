package assessmentApp;

import org.hibernate.Session;
import com.github.javafaker.Faker;
import pojo.Result;
import util.HibernateSessionFactory;

public class TestResult {

	public static void main(String[] args) {

		Faker faker = new Faker();
		Session session = HibernateSessionFactory.getSession();
	
		try {
			session.getTransaction().begin();
			for (int i = 0; i < 10; i++) {
				
			Result results = new Result();
			results.setTime(faker.date().birthday()+"");
			results.setDuration(faker.number().numberBetween(0, 60)+"");
			results.setMarks(faker.number().randomDigit());
			results.setQuestionsAttempted(faker.number().randomDigit());
			results.setQuestionsNotAttempted(faker.number().randomDigit());
			
			session.save(results);
			}
			session.getTransaction().commit();
		}
		finally {
			session.close();
		}
		System.exit(0);
				
	}
	
	

}
