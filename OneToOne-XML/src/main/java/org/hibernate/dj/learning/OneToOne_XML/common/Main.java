package org.hibernate.dj.learning.OneToOne_XML.common;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.dj.learning.OneToOne_XML.model.Employee;
import org.hibernate.dj.learning.OneToOne_XML.model.EmployeeDetail;
import org.hibernate.dj.learning.OneToOne_XML.persistence.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		EmployeeDetail employeeDetail = new EmployeeDetail("Indore", "Indore", "MP", "India");
		
		Employee employee = new Employee("Diwyang", "Jain", new Date(121212),
				"123121211");
		employee.setEmployeeDetail(employeeDetail);
		employeeDetail.setEmployee(employee);
		
		
		session.save(employee);

		
		List<Employee> employees = session.createQuery("from Employee").list();
		for (Employee employee1 : employees) {
			System.out.println(employee1.getFirstname() + " , "
					+ employee1.getLastname() + ", "
					+ employee1.getEmployeeDetail().getState());
		}

		session.getTransaction().commit();
		session.close();

	}
}
