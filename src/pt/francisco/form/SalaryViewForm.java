package pt.francisco.form;

import com.opensymphony.xwork2.ActionSupport;

public class SalaryViewForm extends ActionSupport {
	
	public static final long serialVersionUID = 5L;
	
	private String firstName;
	private String lastName;
	private String step;
	private String value;
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
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
