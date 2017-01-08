package de.htw_berlin.ai_bachelor.kbe.checklist9.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Interval {

	private int min;
	
	@Min(1) 
	@NotNull
	private int max;

	public Interval(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return this.min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		System.out.println("hallo?");
		return this.max;
	}

	public void setMax(int max) {
		this.max = max;
	}
}
