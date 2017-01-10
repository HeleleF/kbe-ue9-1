package de.htw_berlin.ai_bachelor.kbe.checklist9.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.htw_berlin.ai_bachelor.kbe.checklist9.model.ToDoList;
import de.htw_berlin.ai_bachelor.kbe.checklist9.persistenz.ToDoFacade;

// TodoList wird zur besseren Wiederverwendbarkeit referenziert von der ManagedBean
// so kann die Klasse TodoList immer noch fuer anderes verwendet werden

/**
 * Angepasst fuer 9.2 c) :
 * die @ManagedBean Annotation wurde entfernt
 * die @Named Annotation wurde hinzugefuegt,
 * @RequestScoped import wurde ersetzt durch javax.enterprise.context
 * 
 * new ToDoFacade() wurde rausgenommen nach Aufgabenstellung d
 * das Feld ToDoFacade hat jetzt die @Inject Annotation
 */
@Named
@RequestScoped
public class ToDoListMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ToDoFacade _todofacade;

    private ToDoList toDoList;
    
//	public ToDoListMB() {
//		super();
//		this.toDoList = new ToDoList();	
//		this._todofacade = new ToDoFacade();
//		this.toDoList.setToDos(_todofacade.getListOfToDos());
//	}    
	
    // "dependencies are injected after construction"!
    // ich kann getListOfToDos() also nicht im Konstruktor aufrufen,
    // weil das Feld _todofacade dort noch null ist
    // -> in der PostConstruct Methode ist die Bean fertig initialisert
    // und Dependencies koennen benutzt werden
	@PostConstruct
	public void init() {
		this.toDoList = new ToDoList();	
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
