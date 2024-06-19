/********************************************************************************************************2*4*w*
 * File:  ListDataDaoImpl.java Course materials CST8277
 *
 * @author Teddy Yap
 */
package databank.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;


/**
 * Description:  API for reading list data from the database
 */
@Named
@ApplicationScoped
public class ListDataDaoImpl implements ListDataDao, Serializable {
	/** Explicitly set serialVersionUID */
	private static final long serialVersionUID = 1L;

	private static final String READ_ALL_PROGRAMS = "SELECT * FROM program";

	@PersistenceContext(name = "PU_DataBank")
	protected EntityManager em;

	@Inject
	protected ExternalContext externalContext;

	private void logMsg(String msg) {
		((ServletContext) externalContext.getContext()).log(msg);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> readAllPrograms() {
		logMsg("reading all programs");
		List<String> programs = new ArrayList<>();
		try {
			programs = (List<String>) em.createNativeQuery(READ_ALL_PROGRAMS).getResultList();
		}
		catch (Exception e) {
			logMsg("something went wrong:  " + e.getLocalizedMessage());
		}
		return programs;
	}

}
