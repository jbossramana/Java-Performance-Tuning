package demo;



import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class onetomany_set_preparedata {
  public static void main(String[] args) {
   	   SessionFactory sessionFactory;
	  sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    
    Transaction tx = session.beginTransaction();


        Event event1 = new Event();
        event1.setName("Hibernate Training");
        event1.setSpeakers(new HashSet());
        event1.getSpeakers().add(new Speaker(event1,"John", "Smith"));
        System.out.println("Check me" + event1.getSpeakers());
        event1.getSpeakers().add(new Speaker(event1,"Dave", "Smith"));
        event1.getSpeakers().add(new Speaker(event1,"Joan", "Smith"));
        session.save(event1);
        
        Event event2 = new Event();
        event2.setName("Spring Training");
        event2.setSpeakers(new HashSet());
        event2.getSpeakers().add(new Speaker(event2,"ram", "rao"));
        System.out.println("Check me" + event2.getSpeakers());
        event2.getSpeakers().add(new Speaker(event2,"jan", "mahesh"));
        event2.getSpeakers().add(new Speaker(event2,"david", "boss"));
        session.save(event2);
        
        Event event3 = new Event();
        event3.setName("Ejb3 Training");
        event3.setSpeakers(new HashSet());
        event3.getSpeakers().add(new Speaker(event3,"ram", "sagar"));
        System.out.println("Check me" + event3.getSpeakers());
        event3.getSpeakers().add(new Speaker(event3,"smith", "ok"));
        session.save(event3);
        
        tx.commit();
        session.close();
  }
}