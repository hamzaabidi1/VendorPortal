package com.smartech.vendorportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table
public class Attachement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attachementId;
	@Size(max = 50)
	private String objectName;
	private Long objectId;
	private EBlog blog;

	public Attachement(Long attachementId, @Size(max = 50) String objectName, Long objectId, EBlog blog) {
		super();
		this.attachementId = attachementId;
		this.objectName = objectName;
		this.objectId = objectId;
		this.blog = blog;
	}

	public Long getAttachementId() {
		return attachementId;
	}

	public void setAttachementId(Long attachementId) {
		this.attachementId = attachementId;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public EBlog getBlog() {
		return blog;
	}

	public void setBlog(EBlog blog) {
		this.blog = blog;
	}

}
