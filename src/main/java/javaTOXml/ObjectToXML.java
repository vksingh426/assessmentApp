package javaTOXml;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.github.javafaker.Faker;



public class ObjectToXML {
	
	public static void main(String[] args) {

		Faker faker = new Faker();
		AssessmentData data1 = new AssessmentData();
		data1.setId(faker.number().randomDigitNotZero());
		data1.setRole(1+"");
		data1.setDate(31/12/2012+"");
		data1.setTitle("Train based problems");
		data1.setDescription("Advanced");
	    
		Set<QuestionData> quesList = new HashSet<>();
	   for (int i = 0; i <20; i++) {
		   
		QuestionData data2 = new QuestionData();
		data2.setId(i);
		data2.setText("A train running at the speed of 60 km/hr crosses a pole in 9 seconds. What is the length of the train?");
		data2.setAttempted(true);
	    data2.setMarks(faker.number().numberBetween(10, 90));
	    data2.setTime("2-Hours");
	    
	    quesList.add(data2);
	   }
	    data1.setQuestionDatas(quesList);
	    
	    try {

			File file = new File("C:\\Users\\Vaibhav\\Desktop\\XML.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(AssessmentData.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(data1, file);
			jaxbMarshaller.marshal(data1, System.out);

		      } catch (JAXBException e) {
			e.printStackTrace();
		      }

		
	}
}
