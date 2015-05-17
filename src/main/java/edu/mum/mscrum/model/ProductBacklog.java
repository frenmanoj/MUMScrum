package edu.mum.mscrum.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "product_backlog")
public class ProductBacklog {

	private Long id;

	private String title;

	private String description;

	private Set<UserStory> userStories = new HashSet<UserStory>();

	private Set<Release> releases = new HashSet<Release>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@OneToMany(mappedBy = "productBacklog", fetch = FetchType.EAGER)
	@Cascade({ CascadeType.ALL })
	public Set<UserStory> getUserStories() {

		return userStories;
	}

	@OneToMany(mappedBy = "productBacklog", fetch = FetchType.EAGER)
	@Cascade({ CascadeType.ALL })
	public Set<Release> getReleases() {

		return releases;
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

	public void setUserStories(Set<UserStory> userStories) {

		this.userStories = userStories;
	}

	public void addRelease(Release release) {
		this.releases.add(release);
		release.setProductBacklog(this);
	}

	public void setReleases(Set<Release> releases) {

		this.releases = releases;
	}

	public void addUserStory(UserStory userStory) {
		this.userStories.add(userStory);
		userStory.setProductBacklog(this);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
