package de.htw_berlin.ai_bachelor.kbe.checklist9.persistenz;

import de.htw_berlin.ai_bachelor.kbe.checklist9.model.ToDo;

public class ToDoDAO extends GenericDAO<ToDo> {

	private static final long serialVersionUID = 1L;
  
	public ToDoDAO() {
		super(ToDo.class);
	}
}
