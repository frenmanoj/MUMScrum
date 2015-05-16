package edu.mum.mscrum.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "release_backlog")
public class Release {
	
	private Long id;
	private String name;
	private String description;
//	private String srumMaster;
	private Date startDate;
	private Date endDate;
	
	private List<UserStory> userStories = new ArrayList<UserStory>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "releaseBacklog", fetch = FetchType.EAGER)
	public List<UserStory> getUserStories() {

		return userStories;
	}
	
	public void setUserStories(List<UserStory> userStories) {
		this.userStories = userStories;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(nullable = false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	@Column(nullable = false)
//	public String getSrumMaster() {
//		return srumMaster;
//	}
//	public void setSrumMaster(String srumMaster) {
//		this.srumMaster = srumMaster;
//	}
	@Column(nullable = false)
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Column(nullable = false)
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	

}