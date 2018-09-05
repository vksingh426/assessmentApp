package assessmentApp;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.github.javafaker.Faker;
import pojo.Options;
import pojo.Question;
import util.HibernateSessionFactory;

public class QuestionToOptions {

	public static void main(String[] args) {

		Faker faker = new Faker();
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;

		try {
			session.beginTransaction();
			
			Set<Question> list = new HashSet<>();
			Question question = new Question();
			for (int i = 0; i < 3; i++) {
				
			question.setText("text");
			question.setTime("time");
			question.setAttempted(false);
			question.setMarks(faker.number().randomDigit());
			list.add(question);
			}
			Set<Options> optionList = new HashSet<>();
			Options options = new Options();
			for (int i = 0; i < 3; i++) {
				
			options.setText(question.getText());
			options.setCorrect(true);
			optionList.add(options);
			
			question.setOptions(optionList);
			options.setQuestions(list);
			session.save(optionList);
 			session.save(list);
			}
 			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("DONE");
		System.exit(0);
	}

}
