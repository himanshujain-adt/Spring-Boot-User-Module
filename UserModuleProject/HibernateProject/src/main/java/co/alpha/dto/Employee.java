package co.alpha.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ST_EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long empId;
	@Column(name = "EMP_NAME")
	private String empName;
	@Column(name = "EMP_ADDRESS")
	private String empAddress;
	@Column(name = "EMP_SALARY")
	private String empSalary;
	@Column(name = "EMP_MOBILENO")
	private String empMobileNo;

}
