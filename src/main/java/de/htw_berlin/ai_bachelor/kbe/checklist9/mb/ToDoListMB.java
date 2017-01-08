package de.htw_berlin.ai_bachelor.kbe.checklist9.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import de.htw_berlin.ai_bachelor.kbe.checklist9.model.ToDoList;
import de.htw_berlin.ai_bachelor.kbe.checklist9.persistenz.ToDoFacade;

// TodoList wird zur besseren Wiederverwendbarkeit referenziert von der ManagedBean
// so kann die Klasse TodoList immer noch fuer anderes verwendet werden

@RequestScoped
@ManagedBean
public class ToDoListMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ToDoFacade _todofacade;

    private ToDoList toDoList;
    
	public ToDoListMB() {
		super();
		this.toDoList = new ToDoList();	
		this._todofacade = new ToDoFacade();
		
		// alle vorhandenen reinpacken
		this.toDoList.setToDos(_todofacade.getListOfToDos());
	}    

	public ToDoList getToDoList() {
				
		return this.toDoList;
	}

	//Should be called if the Button "Speichern" is pushed.
	//Needs configuration in the faces-config.xml.
	// Controller erweitert theoretisch
    public String save() {
    	
    	// alle vorhandenen speichern
    	this._todofacade.setListOfToDos(this.toDoList.getToDos());
    	
    	return "save";
    }
}
