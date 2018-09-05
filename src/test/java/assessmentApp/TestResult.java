package assessmentApp;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.github.javafaker.Faker;
import pojo.Question;
import pojo.Result;
import util.HibernateSessionFactory;

public class TestResult {

	public static void main(String[] args) {

		Faker faker = new Faker();
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
	
		try {
			session.beginTransaction();
			Question question = new Question();
			Result results = new Result();
			results.setTime(question.getTime());
			results.setDuration(faker.number().numberBetween(0, 60)+"");
			results.setMarks(faker.number().randomDigit());
			results.setQuestionsAttempted(faker.number().randomDigit());
			results.setQuestionsNotAttempted(faker.number().randomDigit());
			
			session.save(results);
			transaction.commit();
		}
		finally {
			session.close();
		}
		System.exit(0);
	}

}
