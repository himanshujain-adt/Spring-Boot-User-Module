package co.alpha.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import co.alpha.dto.Employee;

public class EmployeeModel {

	public Long add() {
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employee emp = new Employee();
		emp.setEmpName("Himanshu Jain");
		emp.setEmpAddress("Indore");
		emp.setEmpMobileNo("9691969842");
		emp.setEmpSalary("50000");
		System.out.println("Emp data===>>>>" + emp.getEmpName() + " " + emp.getEmpAddress());
		session.persist(emp);
		System.out.println("Data addedd in DB DAO layer===>>>>>>>");
		tx.commit();

		return emp.getEmpId();
	}

	public static void main(String[] args) {
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.add();
	}
}
