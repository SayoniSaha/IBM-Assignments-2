package factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.CourseEntity;

public class HibernateSessionFactory {
	
	private static SessionFactory sessionFactory=null;
	
	private static Session session=null;
	
	public static Session getHibernateSession()throws Exception {
		sessionFactory=new Configuration().configure().addAnnotatedClass(CourseEntity.class).buildSessionFactory();
		
		session = sessionFactory.openSession();
		return session;
	}

}

