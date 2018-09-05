package assessmentApp;

import javax.transaction.Transaction;

import org.hibernate.Session;

import com.github.javafaker.Faker;

import util.HibernateSessionFactory;

public class UserToProfile {

	public static void main(String[] args) {
		System.out.println("Done");
		Faker faker = new Faker();
		
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			
		}
		
		
		
	}

}
