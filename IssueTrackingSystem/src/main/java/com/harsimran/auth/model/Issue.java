package com.harsimran.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "issue_info")
public class Issue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String issueName;

	private IssueType issueType = IssueType.UNASSIGNED;

	private String subject;

	private String description;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IssueType getIssueType() {
		return issueType;
	}

	public void setIssueType(IssueType issueType) {
		this.issueType = issueType;
	}
	
	public Issue() {
		// TODO Auto-generated constructor stub
	}

	public Issue(Long id, String issueName, IssueType issueType, String subject, String description) {
		super();
		this.id = id;
		this.issueName = issueName;
		this.issueType = issueType;
		this.subject = subject;
		this.description = description;
	}
	
	

}
