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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salary")
public class Salary {
	
	String firstname;
	String lastname;
	String step;
	String value;
	
	public Salary() {
		
	}
	
	@Embeddable
	public static class SalaryId implements Serializable { 
		
		public static final long serialVersionUID = 6L;
		 
		public SalaryId(){}
	    
		//@ManyToOne
		@JoinColumn(name = "firstname")
		private String firstName;

		//@ManyToOne
	    @JoinColumn(name = "lastname")
	    private String lastName;
	    
	    public SalaryId(String firstName, String lastName) {
	    	this.firstName = firstName;
	    	this.lastName = lastName;
	    }
	    
	    public void setFirstName(String firstname) {
	    	this.firstName = firstname;
	    }
	    
	    public String getFirstName() {
	    	return firstName;
	    }
	    
	    public void setLastName(String lastName) {
	    	this.lastName = lastName;
	    }
	    
	    public String getLastName() {
	    	return lastName;
	    }
	    
	}
	
	
	@EmbeddedId
	SalaryId id;
	
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


	/**
	 * @return the id
	 */
	public SalaryId getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(SalaryId id) {
		this.id = id;
	}
	
}


