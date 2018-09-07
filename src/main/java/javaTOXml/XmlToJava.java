package javaTOXml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class XmlToJava {
	
	public static void main(String[] args) {
		 
		 try {

				File file = new File("C:\\Users\\Vaibhav\\Desktop\\test.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(AssessmentData.class);

				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				AssessmentData assessment = (AssessmentData) jaxbUnmarshaller.unmarshal(file);
				
				System.out.println("assessment getExamdate "+assessment.getDate());
				System.out.println("assessment getName "+assessment.getTitle());
				System.out.println("assessment getRole "+assessment.getRole());
				System.out.println("assessment getDescription "+assessment.getDescription());

				for (QuestionData questions : assessment.getQuestionDatas()) {
					System.out.println("questions.getTime() "+questions.getTime());
					for (OptionData option : questions.getOptionDatas()) {
						System.out.println("option.getText() "+option.getText());
						System.out.println("option.getIs_correct() "+option.isCorrect());
						System.out.println("************************************");

					}
					
				}

			  } catch (JAXBException e) {
				e.printStackTrace();
			  }

}
}
