/********************************************************************************************************2*4*w*
 * File:  StudentDaoImpl.java Course materials CST8277
 *
 * @author Teddy Yap
 * @author Shahriar (Shawn) Emami
 * @author (original) Mike Norman
 */
package databank.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import databank.model.StudentPojo;
import databank.ejb.*;

/**
 * Description:  Implements the C-R-U-D API for the database
 */
@Named
@ApplicationScoped
public class StudentDaoImpl implements StudentDao, Serializable {
	/** explicitly set serialVersionUID */
	private static final long serialVersionUID = 1L;

	//Get the log4j2 logger for this class
	private static final Logger LOG = LogManager.getLogger();

	@EJB
	protected  StudentService studentService;

	@Override
	public List<StudentPojo> readAllStudents() {
		return studentService.readAllStudents();
	}

	@Override
	public StudentPojo createStudent(StudentPojo student) {
		return studentService.createStudent(student);
		 
	}

	@Override
	public StudentPojo readStudentById(int studentId) {
		 
		return studentService.readStudentById(studentId);
	}

	@Override
	public StudentPojo updateStudent(StudentPojo studentWithUpdates) {
		return studentService.updateStudent(studentWithUpdates);
		
	}

	@Override
	public void deleteStudentById(int studentId) {
		studentService.deleteStudentById(studentId);
	}

}
