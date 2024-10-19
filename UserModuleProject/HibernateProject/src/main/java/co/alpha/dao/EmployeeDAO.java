package co.alpha.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import co.alpha.dto.Employee;
import co.alpha.dto.EmployeeDTO;
import co.alpha.dto.EmployeeMapper;

public class EmployeeDAO {

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
		session.save(emp);
		System.out.println("Data addedd in DB DAO layer===>>>>>>>");
		return emp.getEmpId();
	}

	public EmployeeDTO convertToDTO(Employee employee) {
		return EmployeeMapper.INSTANCE.toDTO(employee);
	}

	public Employee convertToEntity(EmployeeDTO employeeDTO) {
		return EmployeeMapper.INSTANCE.toEntity(employeeDTO);
	}

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		dao.add();
	}
}
