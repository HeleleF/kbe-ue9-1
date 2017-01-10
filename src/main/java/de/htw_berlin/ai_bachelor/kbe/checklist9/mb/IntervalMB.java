package de.htw_berlin.ai_bachelor.kbe.checklist9.mb;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import de.htw_berlin.ai_bachelor.kbe.checklist9.model.Interval;

/**
 * Angepasst fuer 9.2 c) :
 * die @ManagedBean Annotation wurde entfernt
 * die @Named Annotation wurde hinzugefuegt,
 * @ApplicationScoped import wurde ersetzt durch javax.enterprise.context
 *
 */
@Named
@ApplicationScoped
public class IntervalMB {

	private Interval interval;
	
	public IntervalMB() {
		interval = new Interval(1, 6);
	}

	public Interval getInterval() {
		return this.interval;
	}

	public String save() {
		return "save";
	}
}
