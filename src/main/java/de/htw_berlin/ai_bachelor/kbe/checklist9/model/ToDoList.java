package de.htw_berlin.ai_bachelor.kbe.checklist9.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ToDoList implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private List<ToDo> toDos;
	
	
	public ToDoList() {
		super();
		//this.setToDos();
		toDos =  new ArrayList<ToDo>();
	}
		
	public List<ToDo> getToDos() {
		return this.toDos;
	}
	
	public int getAnzahl() {
		int anzahl;
		if (this.toDos == null) {
			anzahl = 0;
		} else {
			anzahl = this.toDos.size();
		}
		return anzahl;
	}
	
	public int getAnzahlDone() {
		int anzahlDone = 0;
		for (final ToDo td : this.toDos) { //Todo td ist ja Iterator und sollte also nicht veraendert werden, deshalb final
			if (td.isDone()) anzahlDone++;
		}
		return anzahlDone;
	}

	public void setToDos(List<ToDo> todolist) {
		this.toDos = todolist;		
	}
}
