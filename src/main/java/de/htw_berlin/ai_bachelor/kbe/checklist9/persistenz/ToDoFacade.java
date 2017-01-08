package de.htw_berlin.ai_bachelor.kbe.checklist9.persistenz;

import java.util.List;

import de.htw_berlin.ai_bachelor.kbe.checklist9.model.ToDo;

/**
 * 
 * eine Fassade fuer ToDoDAO siehe Aufgabe 9.1 Hinweis 3
 * 
 * TODO: Braucht man try/catch ueberhaupt?
 *
 */
public class ToDoFacade {

	private ToDoDAO _todoDAO;

	public ToDoFacade() {
		this._todoDAO = new ToDoDAO();
	}

	/**
	 * zum Speichern eines ToDo-Objektes in die DB
	 * 
	 * @param ein_todo
	 *            ToDo-Objekt, das gespeichert werden soll
	 */
	public void saveOneToDo(ToDo ein_todo) {

		try {
			_todoDAO.beginTransaction();
			_todoDAO.save(ein_todo);
			_todoDAO.commit();
			_todoDAO.closeTransaction();

		} catch (Exception e) {
			System.out.println("Irgendwas ist schiefgegangen: " + e.getLocalizedMessage());
			_todoDAO.rollback();
		}
	}

	/**
	 * zum Speichern einer Liste von ToDo-Objekten in die DB
	 * 
	 * @param eine_todo_liste
	 *            Liste von ToDo-Objekten, die gespeichert werden sollen
	 */
	public void setListOfToDos(List<ToDo> eine_todo_liste) {

		try {
			_todoDAO.beginTransaction();

			for (ToDo ein_todo : eine_todo_liste) {
				_todoDAO.update(ein_todo);
			}

			_todoDAO.commit();
			_todoDAO.closeTransaction();

		} catch (Exception e) {
			System.out.println("Irgendwas ist schiefgegangen: " + e.getLocalizedMessage());
			_todoDAO.rollback();
		}
	}

	/**
	 * zum Holen einer Liste von ToDo-Objekten aus der DB
	 * 
	 * @return eine Liste von ToDo-Objekten
	 */
	public List<ToDo> getListOfToDos() {

		List<ToDo> eine_neue_todo_liste = null;

		try {
			_todoDAO.beginTransaction();
			eine_neue_todo_liste = _todoDAO.findAll();
			_todoDAO.commit();
			_todoDAO.closeTransaction();

		} catch (Exception e) {
			System.out.println("Irgendwas ist schiefgegangen: " + e.getLocalizedMessage());
			_todoDAO.rollback();
		}

		return eine_neue_todo_liste;
	}
}
