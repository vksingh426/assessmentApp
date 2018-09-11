package assessmentApp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.hibernate.Session;
import com.github.javafaker.Faker;
import javaTOXml.OptionData;
import javaTOXml.QuestionData;
import pojo.Assessment;
import pojo.Options;
import pojo.Question;

import util.HibernateSessionFactory;

public class AddData {

	public static void main(String[] args) {

		Session session = HibernateSessionFactory.getSession();

		try {

			session.getTransaction().begin();
			File file = new File("C:\\Users\\Vaibhav\\Desktop\\XML.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(javaTOXml.AssessmentData.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			javaTOXml.AssessmentData assesment = (javaTOXml.AssessmentData) jaxbUnmarshaller.unmarshal(file);

			Assessment assessment = new Assessment(assesment.getRole(), assesment.getTitle(), assesment.getDate(),
					assesment.getDescription());
			
			session.save(assessment);

			Set<Assessment> assessments = new HashSet<>();
			assessments.add(assessment);
        
			
			Set<Question> questionDatas = new HashSet<>();
			for (QuestionData questionData : assesment.getQuestionDatas()) {
				// this is where i will create hibernate Question pojo

				Question question = new Question(questionData.getText(), questionData.getTime(),
						questionData.getMarks(), false);

				questionDatas.add(question);
				session.save(question);
			
				Set<Question> questionDatas1 = new HashSet<>();
				Set<Options> optionDatas = new HashSet<>();
				for (OptionData optionData : questionData.getOptionDatas()) {
					// this is where i will create hibernate Option pojo
					Options options = new Options(optionData.getText(), optionData.isCorrect());

					session.save(options);
					optionDatas.add(options);
					questionDatas1.add(question);
					options.setQuestions(questionDatas1);
				}
			question.setOptions(optionDatas);
			question.setAssessmentList(assessments);
			}
			assessment.setQuestionList(questionDatas);
			session.getTransaction().commit();
		} catch (JAXBException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("DONE");
		System.exit(0);

	}
}