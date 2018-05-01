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
import javax.persistence.Table;

@Entity
@Table(name = "salary")
public class Salary {
	
	Integer employeeId;
	String firstName;
    String lastName;
	String step;
	String value;
	
	public Salary() {
		
	}
	
	/**
	 * @return the employee_Id
	 */
	@Id
	@Column(name = "employee_Id")
	public Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employee_Id the employee_Id to set
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
	 * @return the firstName
	 */
	@Column(name = "firstName")
	public String getFirstName() {
    	return firstName;
    }
	 
	/**
	 * @param firstName the firstName to set
	 */
    public void setFirstName(String firstname) {
    	this.firstName = firstname;
    }
    
    /**
	 * @return the lastName
	 */
    @Column(name = "lastName")
    public String getLastName() {
    	return lastName;
    }
    
    /**
	 * @param lastName the lastName to set
	 */
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
	/**
	 * @return the step
	 */
	@Column(name = "step")
	public String getStep() {
		return step;
	}

	/**
	 * @param step the step to set
	 */
	public void setStep(String step) {
		this.step = step;
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


