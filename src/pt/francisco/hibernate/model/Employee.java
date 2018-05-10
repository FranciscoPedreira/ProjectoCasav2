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
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	Integer employeeId;
    String firstName;
    String lastName;
	String department;
	String address;
	String country;
	
	public Employee() {
		
	}
	

	/**
	 * @return the employeeId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employeeId")
	public Integer getEmployeeId() {
		return employeeId;
	}


	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	
    /**
	 * @return the firstname
	 */
    @Column(name = "firstname")
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
	 * @return the department
	 */
	@Column(name = "department")
	public String getDepartment() {
		return department;
	}


	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}


	/**
	 * @return the address
	 */
	@Column(name = "address")
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the country
	 */
	@Column(name = "country")
	public String getCountry() {
		return country;
	}


	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}


	
	
	
	
}


