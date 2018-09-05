package assessmentApp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.github.javafaker.Faker;
import pojo.Assessment;
import pojo.Question;
import util.HibernateSessionFactory;

public class AssessmentToQuestion {

	public static void main(String[] args) {
		Faker faker = new Faker();
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;

		try {
			session.getTransaction().begin();

		Set<Question> questionsList = new HashSet<>();
		Set<Assessment> assessmentsList = new HashSet<>();

		Question questions = new Question();	
		for (int i = 0; i < 2; i++) {
		
		questions.setText("abc");
		questions.setTime("time");
		questions.setMarks(faker.number().randomDigit());
		questions.setAttempted(true);
		questionsList.add(questions);
				
		Assessment assessment = new Assessment();
		for (int j = 0; j < 2; j++) {
		assessment.setRole("role");
		assessment.setTitle("title");
		assessment.setDate("date");
		assessment.setDescription("description");
		assessmentsList.add(assessment);
		
		assessment.setQuestionList(questionsList);
		questions.setAssessmentList(assessmentsList);
		session.save(assessment);
		session.getTransaction().commit();
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
				System.out.println("DONE");
				System.exit(0);
	}
}
