package de.htw_berlin.ai_bachelor.kbe.checklist9.model;

import de.htw_berlin.ai_bachelor.kbe.checklist9.validierung.MyInterval;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Calendar;
import java.util.Date;

@Entity(name = "todo")
@Access(AccessType.FIELD)
public class ToDo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int todo_id;
	
	@NotNull
	private String name;
	
	private boolean done = false;
	
	@NotNull
	@MyInterval
	private int prioritaet;
	
	@NotNull
	@Future()
	private Date dueDate;
	
	// leerer public Konstruktor ist erforderlich 
	public ToDo() {	
	}
	
	public ToDo(String name, boolean done, int prio) {
		super();
		this.name = name;
		this.done = done;
		this.prioritaet = prio;
		
		Calendar c = Calendar.getInstance();	
		c.add(Calendar.DATE, 1);		
		this.dueDate = c.getTime();
	}
		
	public ToDo(String name) {
		this(name, false, 1);
	}
	
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date date) {
		dueDate = date;
	}

	public int getPrioritaet() {
		return prioritaet;
	}

	public void setPrioritaet(int prioritaet) {
		this.prioritaet = prioritaet;
	}
	
	// TODO: Braucht man das?
	public int getID() {
		return todo_id;
	}

}
