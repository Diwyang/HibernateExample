package org.hibernate.web.sample;  



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

 
public class UserDao {  

public static void main(String ...args) {
	
	User u = new User();
	u.setName("Gajendra");
	u.setPassword("thakur");
	u.setEmail("t@dxc.com");
	register(u);
}
  
public static int register(User u){  
 int i=0;  

 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
 Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

SessionFactory factory = meta.getSessionFactoryBuilder().build();
Session session = factory.openSession();
Transaction t = session.beginTransaction(); 

i=(Integer)session.save(u);  

t.commit();  
session.close();  
  
return i;  
 
 }  
}  