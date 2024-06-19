package databank.ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import databank.model.StudentPojo;

@Singleton
public class StudentService implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(name = "PU_DataBank")
	protected EntityManager em;

	/**
	 * Default constructor.
	 */
	public StudentService() {
	}

	public List<StudentPojo> readAllStudents() {
		TypedQuery<StudentPojo> allStudentsQuery = em.createNamedQuery("Student.findAll", StudentPojo.class);
		return allStudentsQuery.getResultList();
	}

	public StudentPojo readStudentById(int studentId) {
		return em.find(StudentPojo.class, studentId);
	}

	@Transactional
	public StudentPojo createStudent(StudentPojo student) {
		em.persist(student);
		return student;
	}

	@Transactional
	public StudentPojo updateStudent(StudentPojo studentWithUpdates) {
		StudentPojo studentToBeUpdated = readStudentById(studentWithUpdates.getId());
		if (studentToBeUpdated != null) {
			try {
				em.merge(studentWithUpdates);
			} catch (OptimisticLockException e) {
				System.err.println("Optimistic locking exception occurred: " + e.getMessage());
				return null;

			}
		}
		return studentWithUpdates;
	}

	@Transactional
	public void deleteStudentById(int studentId) {
		StudentPojo student = readStudentById(studentId);
		if (student != null) {
			em.refresh(student);
			em.remove(student);
		}
	}

}