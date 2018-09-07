package assessmentApp;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.github.javafaker.Faker;

import javaTOXml.OptionData;
import javaTOXml.QuestionData;
import pojo.Options;
import pojo.Question;
import util.HibernateSessionFactory;

public class QuestionToOptions {

	public static void main(String[] args) {

		Faker faker = new Faker();
		Session session = HibernateSessionFactory.getSession();
		
		try {
			session.getTransaction().begin();
			
			QuestionData questionData = new QuestionData();
			OptionData optionData = new OptionData();
			
			Set<Options> optionsList = new HashSet<>();
			Set<Question> questionsList = new HashSet<>();
			Question question = new Question();
			for (int i = 0; i < 10; i++) {
				
			question.setText(questionData.getText());
			question.setTime(questionData.getTime());
			question.setAttempted(false);
			question.setMarks(faker.number().randomDigit());
			questionsList.add(question);
			
			Options options = new Options();
			for (int i1 = 0; i1 < 3; i1++) {
				
			options.setText(question.getText());
			options.setCorrect(true);
			optionsList.add(options);
			
			question.setOptions(optionsList);
			options.setQuestions(questionsList);
			session.save(question);
 			session.save(options);
			}
			}
 			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("DONE");
		System.exit(0);
	}

}
