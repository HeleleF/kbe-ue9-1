package de.htw_berlin.ai_bachelor.kbe.checklist9.persistenz;

import javax.inject.Named;

import de.htw_berlin.ai_bachelor.kbe.checklist9.model.ToDo;

/**
 * Eine Data-Access-Object Klasse fuer ToDo-Objekte
 * 
 * Erweitert fuer 9.2:
 * die @Named Annotation wurde hinzugefuegt,
 * damit man ToDoDAO in ToDoFacade injizieren kann
 *
 */
@Named
public class ToDoDAO extends GenericDAO<ToDo> {

	private static final long serialVersionUID = 1L;
  
	public ToDoDAO() {
		super(ToDo.class);
	}
}
