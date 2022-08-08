package demo;



import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;

public class onetomany_set_list {
  public static void main(String[] args) {
   	 String query = "from Event";
   	 SessionFactory sessionFactory;
	  sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    
    
List list = session.createQuery("from Event e inner join fetch e.speakers as s").list();

//List list = session.createQuery("from Event e right outer join fetch e.speakers as s").list();

//List<Event> list = session.createQuery(query).list();
 


    
     displayObjectsList(list);  
  
     
//     session.close();
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
          System.out.println("New Event :");
           Event event = (Event) iter.next();
           System.out.println(event.getName());
           Iterator iter2 = event.getSpeakers().iterator();
           while(iter2.hasNext())
        		   {
        	         Speaker speaker = (Speaker) iter2.next();
        	         System.out.println(speaker.getFirstName());
        	         System.out.println(speaker.getLastName());
        	  //   if(iter.hasNext()) iter.next();
        		   }
         
      }
  }    
}
