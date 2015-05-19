package edu.mum.mscrum.model;

import java.util.Date;

public class ViewBurndown {

	private int remainingWork;
	private Date day;
	private Sprint sprint;

	public int getRemainingWork() {
		return remainingWork;
	}

	public void setRemainingWork(int remainingWork) {
		this.remainingWork = remainingWork;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}
}
