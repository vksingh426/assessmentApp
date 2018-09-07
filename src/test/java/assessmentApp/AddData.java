package assessmentApp;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
		Faker faker = new Faker();
		Session session = HibernateSessionFactory.getSession();


		try {
			session.getTransaction().begin();
			File file = new File("C:\\Users\\Vaibhav\\Desktop\\XML.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(javaTOXml.AssessmentData.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			javaTOXml.AssessmentData assesment = (javaTOXml.AssessmentData) jaxbUnmarshaller.unmarshal(file);
		
			session.getTransaction().begin();
			
			Assessment assessment = new Assessment(assesment.getRole(), assesment.getTitle(), assesment.getDate(), assesment.getDescription());
			session.save(assessment);
			
			List<QuestionData> questionDatas = new ArrayList<>();
			List<OptionData> optionDatas = new ArrayList<>();
			List<Assessment> assessments = new ArrayList<>();
			assessments.add(assessment);
			
			for (QuestionData questionData : assesment.getQuestionDatas()) {
				//this is where i will create hibernate Question pojo
				
				Question question = new Question(questionData.getText(), questionData.getTime(), questionData.getMarks(), false);
				session.save(question);
				
				
				for (OptionData optionData : questionData.getOptionDatas()) {
					//this is where i will create hibernate Option pojo
					Options options = new Options(optionData.getText(), optionData.isCorrect());
					
					session.save(options);
					optionDatas.add(optionData);
				}
				questionDatas.add(questionData);
			}
			
			
			
			
			session.getTransaction().commit();			
			  } catch (JAXBException e) {
				e.printStackTrace();
			  }finally {
				session.close();
			}
				System.out.println("DONE");
				System.exit(0);
	
}
}