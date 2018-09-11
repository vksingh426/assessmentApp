package assessmentApp;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBException;

import org.hibernate.Session;

import com.github.javafaker.Faker;

import pojo.Assessment;
import pojo.Question;
import util.HibernateSessionFactory;

public class AssessmentToQuestion {
	
	public static void main(String[] args) throws JAXBException {
		
	Faker faker = new Faker();
	Session session = HibernateSessionFactory.getSession();
	try {
		session.getTransaction().begin();

		for (int i = 0; i < 10; i++) {
		
	Set<Question> questionsList = new HashSet<>();
	Set<Assessment> assessmentsList = new HashSet<>();
	
    Question questions = new Question();	
	questions.setText("abc"); 
	questions.setTime("time");
	questions.setMarks(faker.number().randomDigit());
	questions.setAttempted(true);
	questionsList.add(questions);
			
	Assessment assessment = new Assessment();
	
	assessment.setRole("role");
	assessment.setTitle("title");
	assessment.setDate("date");
	assessment.setDescription("description");
	assessmentsList.add(assessment);
	
	assessment.setQuestionList(questionsList);
	questions.setAssessmentList(assessmentsList);
	session.save(assessment);
	session.save(questions);
		}
	session.getTransaction().commit();
	}
	finally {
		session.close();
	}
		System.out.println("DONE");
		System.exit(0);

}

}
