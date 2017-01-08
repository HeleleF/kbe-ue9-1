package de.htw_berlin.ai_bachelor.kbe.checklist9.mb;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import de.htw_berlin.ai_bachelor.kbe.checklist9.model.Interval;

@ApplicationScoped
@ManagedBean
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
