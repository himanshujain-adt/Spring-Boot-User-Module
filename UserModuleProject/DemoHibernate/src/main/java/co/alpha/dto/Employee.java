package co.alpha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ST_EMPLOYEE")
public class Employee {

	@Id
	private Long empId;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "emp_address")
	private String empAddress;

	@Column(name = "emp_salary")
	private String empSalary;

	@Column(name = "emp_mobile_no")
	private String empMobileNo;
}
