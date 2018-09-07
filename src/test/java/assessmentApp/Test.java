package assessmentApp;

import dao.AssessmentDAO;
import dao.OptionsDAO;
import dao.QuestionDAO;
import dao.ResultDAO;
import dao.UserDAO;
import dao.UserProfileDAO;
import pojo.Assessment;
import pojo.Options;
import pojo.Question;
import pojo.Result;
import pojo.User;
import pojo.UserProfile;

public class Test {
	public static void main(String[] args) {

		UserDAO userdao = new UserDAO();
		User user = userdao.findById(2);
		System.out.println(user.getEmail());

		UserProfileDAO profiledao = new UserProfileDAO();
		UserProfile profile = profiledao.findById(5);
		System.out.println(profile.getAddress());

		AssessmentDAO assessmentDAO = new AssessmentDAO();
		Assessment assessment = assessmentDAO.findById(10);
		System.out.println(assessment.getDescription());

		QuestionDAO questionDAO = new QuestionDAO();
		Question question = questionDAO.findById(10);
		System.out.println(question.getMarks());

		OptionsDAO optionsDAO = new OptionsDAO();
		Options options = optionsDAO.findById(10);
		System.out.println(options.getText());
		
		ResultDAO resultDAO = new ResultDAO();
		Result result = resultDAO.findById(4);
		System.out.println(result.getDuration());
	}

}
