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
@Table(name = "salary")
public class Salary implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8888721290651895730L;
	
	int salaryId;
	String salaryGroup;
	String value;
	
	public Salary() {
		
	}
	
	/**
	 * @return the employee_Id
	 */
	@Id
	@Column(name = "salaryId")
	public int getSalaryId() {
		return salaryId;
	}

	/**
	 * @param employee_Id the employee_Id to set
	 */
	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}
	
	/**
	 * @return the salaryGroup
	 */
	@Column(name = "salaryGroup")
	public String getSalaryGroup() {
		return salaryGroup;
	}

	/**
	 * @param salaryGroup the salaryGroup to set
	 */
	public void setSalaryGroup(String salaryGroup) {
		this.salaryGroup = salaryGroup;
	}

	/**
	 * @return the value
	 */
	@Column(name = "value")
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}


