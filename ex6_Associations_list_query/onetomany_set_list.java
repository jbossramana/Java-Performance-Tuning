package demo;



import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;

public class onetomany_set_list {
  public static void main(String[] args) {
   	   SessionFactory sessionFactory;
	  sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    
    Transaction tx = session.beginTransaction();


        Event event = new Event();
        event.setName("One-to-many test");
        event.setSpeakers(new HashSet());
        event.getSpeakers().add(new Speaker("John", "Smith"));
        System.out.println("Check me" + event.getSpeakers());
        event.getSpeakers().add(new Speaker("Dave", "Smith"));
        event.getSpeakers().add(new Speaker("Joan", "Smith"));
        Speaker speaker = new Speaker("raman","rao");
        
        Event event2 = new Event();
        event2.setName("one more");
        speaker.setEvent(event2);
      
        session.saveOrUpdate(event);
        session.saveOrUpdate(event2);
        session.saveOrUpdate(speaker);
        tx.commit();
        Session session2 = sessionFactory.openSession();
        List list = session2.createQuery("from Event").list();
       
       displayObjectsList(list);  
        session.close();
        sessionFactory.close();
        }
        
  

      static public void displayObjectsList(List list)
  {
    	  
  
      Iterator iter = list.iterator();
      if (!iter.hasNext())
      {
          System.out.println("No Events to display.");
          return;
      }
      while (iter.hasNext())
      {
          System.out.println("New Event");
           Event event = (Event) iter.next();
           System.out.println(event.getName());
         
      }
  }    
}
