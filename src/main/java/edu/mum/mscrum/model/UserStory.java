package edu.mum.mscrum.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_story")
public class UserStory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private double estimatedHours;

	@Column
	private double remainingHours;

	@Column
	private Date createdDate;

	@Column
	private Date assignedDate;

	@Column
	private Date completedDate;

	@ManyToOne
	@JoinColumn(name = "product_backlog_id", nullable = false)
	private ProductBacklog productBacklog;

	@ManyToOne
	@JoinColumn(name = "release_backlog_id", nullable = true)
	private Release releaseBacklog;
	
	public Release getReleaseBacklog() {
		return releaseBacklog;
	}

	public void setReleaseBacklog(Release releaseBacklog) {
		this.releaseBacklog = releaseBacklog;
	}

	public long getId() {
		return id;
	}

	public void setId(long featureId) {

		this.id = featureId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {

		this.title = title;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public double getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(double estimatedHours) {

		this.estimatedHours = estimatedHours;
	}

	public double getRemainingHours() {
		return remainingHours;
	}

	public void setRemainingHours(double remainingHours) {

		this.remainingHours = remainingHours;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {

		this.createdDate = createdDate;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {

		this.assignedDate = assignedDate;
	}

	public ProductBacklog getProductBacklog() {
		return productBacklog;
	}

	public void setProductBacklog(ProductBacklog productBacklog) {
		this.productBacklog = productBacklog;
	}

	public String toString() {

		return "[Title: " + getTitle() + ", Description: " + getDescription()
				+ ", Estimated Hours: " + getEstimatedHours()
				+ ", Remaining Hours: " + getRemainingHours() + "]";
	}
}