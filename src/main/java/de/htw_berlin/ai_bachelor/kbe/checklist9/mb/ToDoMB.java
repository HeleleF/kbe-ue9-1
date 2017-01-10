package de.htw_berlin.ai_bachelor.kbe.checklist9.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.htw_berlin.ai_bachelor.kbe.checklist9.model.ToDo;
import de.htw_berlin.ai_bachelor.kbe.checklist9.persistenz.ToDoFacade;

/**
 * Erweitert fuer 9.2 d) :
 * die @ManagedBean Annotation wurde entfernt
 * die @Named Annotation wurde hinzugefuegt,
 * @RequestScoped import wurde ersetzt durch javax.enterprise.context
 * 
 * new ToDoFacade() wurde rausgenommen
 * das Feld ToDoFacade hat jetzt die @Inject Annotation
 *
 */
@Named
@RequestScoped
public class ToDoMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ToDoFacade _todofacade;
	
	private ToDo _todo;
	
	public ToDoMB() {
		_todo = new ToDo("", false, 1);
		// this._todofacade = new ToDoFacade();
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

