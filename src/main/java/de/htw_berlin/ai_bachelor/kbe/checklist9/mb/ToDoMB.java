package de.htw_berlin.ai_bachelor.kbe.checklist9.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import de.htw_berlin.ai_bachelor.kbe.checklist9.model.ToDo;
import de.htw_berlin.ai_bachelor.kbe.checklist9.persistenz.ToDoFacade;

@RequestScoped
@ManagedBean
public class ToDoMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ToDo _todo;
	
	private ToDoFacade _todofacade;

	public ToDoMB() {
		_todo = new ToDo("", false, 1);
		this._todofacade = new ToDoFacade();
	}
	
	public ToDo getTodo() {
		return this._todo;
	}

	//Should be called if the Button "Speichern" is pushed.
	//Needs configuration in the faces-config.xml.
	// Controller erweitert theoretisch
    public String save() {

    	// abspeichern
    	this._todofacade.saveOneToDo(_todo);
    	
    	return "save";
    }
}

