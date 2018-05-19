package pt.francisco.hibernate.model;

import java.io.Serializable;

/**
 * @author Francisco
 *
 */

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeSalary")
public class EmployeeSalary implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8888721290651895730L;
	
	int EmployeeSalaryId;
	int employeeId;
	int salaryId;
	
	public EmployeeSalary() {
		
	}

	/**
	 * @return the employeeSalaryId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employeeSalaryId")
	public int getEmployeeSalaryId() {
		return EmployeeSalaryId;
	}

	/**
	 * @param employeeSalaryId the employeeSalaryId to set
	 */
	public void setEmployeeSalaryId(int employeeSalaryId) {
		EmployeeSalaryId = employeeSalaryId;
	}
	
	/**
	 * @return the employee_Id
	 */
	@Column(name = "employeeId")
	public int getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * @param employee_Id the employee_Id to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the salary_Id
	 */
	@Column(name = "salaryId")
	public int getSalaryId() {
		return salaryId;
	}

	/**
	 * @param salary_Id the salary_Id to set
	 */
	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}
	
}


