package edu.mum.mscrum.model;

import java.util.ArrayList;
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
@Table(name = "product_backlog")
public class ProductBacklog {

	private Long id;

	private String title;

	private String description;

	private List<UserStory> userStories = new ArrayList<UserStory>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productBacklog", fetch = FetchType.EAGER)
	public List<UserStory> getUserStories() {

		return userStories;
	}

	@Column
	public String getTitle() {
		return title;
	}

	@Column
	public String getDescription() {
		return description;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public void setUserStories(List<UserStory> userStories) {

		this.userStories = userStories;
	}

	public void addUserStory(UserStory userStory) {
		this.userStories.add(userStory);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
