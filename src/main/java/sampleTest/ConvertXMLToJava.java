package sampleTest;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ConvertXMLToJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {

				File file = new File("C:\\Users\\Vaibhav\\Downloads\\New folder\\1.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Assesment.class);

				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Assesment assesment = (Assesment) jaxbUnmarshaller.unmarshal(file);
				
				System.out.println("assesment getExamdate "+assesment.getExamdate());
				System.out.println("assesment getName "+assesment.getName());
				System.out.println("assesment getRole "+assesment.getRole());
				System.out.println("assesment getDescription "+assesment.getDescription());

				for (Questions questions : assesment.getQuestions()) {
					System.out.println("questions.getQuestiondescription() "+questions.getQuestiondescription());
					for (Option option : questions.getOption()) {
						System.out.println("option.getText() "+option.getText());
						System.out.println("option.getIs_correct() "+option.getIs_correct());
						System.out.println("************************************");

					}
					
				}

			  } catch (JAXBException e) {
				e.printStackTrace();
			  }

	}

}
