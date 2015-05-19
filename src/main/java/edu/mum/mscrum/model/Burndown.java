package edu.mum.mscrum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="burndown")

public class Burndown {

	private Long id;
	private int remainingWork;
	private int day;

	private Sprint sprint;
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "sprint_id", nullable = false)
	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	@Column(nullable = true)
	public int getRemainingWork() {
		return remainingWork;
	}

	public void setRemainingWork(int remainingWork) {
		this.remainingWork = remainingWork;
	}

	@Column(nullable = true)
	public int getDay() {
		return day;
	}

	
	public void setDay(int day) {
		this.day = day;
	}

	

	
}
