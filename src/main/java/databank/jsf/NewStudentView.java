/********************************************************************************************************2*4*w*
 * File:  NewStudentView.java Course materials CST8277
 *
 * @author Lei Luo
 * @author Teddy Yap
 * @author Shahriar (Shawn) Emami
 * @author (original) Mike Norman
 */
package databank.jsf;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import databank.model.StudentPojo;

/**
 * This class represents the scope of adding a new student to the DB.
 * 
 */
@Named("newStudent")
@ViewScoped
public class NewStudentView implements Serializable {
	/** explicit set serialVersionUID */
	private static final long serialVersionUID = 1L;

	protected String lastName;
	protected String firstName;
	protected String email;

	protected String phoneNumber;
	protected String program;

	@Inject
	@ManagedProperty("#{studentController}")
	protected StudentController studentController;

	public NewStudentView() {
	}

	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return program
	 */
	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public void addStudent() {
		if (allNotNullOrEmpty(firstName,
				lastName,email,phoneNumber,program)) {
			StudentPojo theNewStudent = new StudentPojo();
			theNewStudent.setFirstName(firstName);
			theNewStudent.setLastName(lastName);
			theNewStudent.setEmail(email);
			theNewStudent.setPhoneNumber(phoneNumber);
			theNewStudent.setProgram(program);
			//Call other setters
			studentController.addNewStudent(theNewStudent);
			// Clean up
			studentController.toggleAdding();
			setFirstName(null);
			setLastName(null);
			//Set everything else to null
			setEmail(null);
			setPhoneNumber(null);
			setProgram(null);
		}
	}

	static boolean allNotNullOrEmpty(final Object... values) {
		if (values == null) {
			return false;
		}
		for (final Object val : values) {
			if (val == null) {
				return false;
			}
			if (val instanceof String) {
				String str = (String) val;
				if (str.isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
}
