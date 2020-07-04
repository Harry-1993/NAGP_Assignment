package com.harsimran.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.harsimran.auth.model.Issue;
import com.harsimran.auth.repository.IssueRepository;

@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	private IssueRepository issueRepo;

	public Issue saveIssue(Issue issue) {
		return issueRepo.save(issue);

	}
	
	public List<Issue> saveAllissues(List<Issue> allIssues) {
		return issueRepo.saveAll(allIssues);
	}

	public List<Issue> getAllIssues() {
		return issueRepo.findAll();

	}

	public Issue getIssueById(int id) {
		return issueRepo.findById((long) id).orElse(null);

	}
	

	public String deleteIssue(int id) {
		issueRepo.deleteById((long) id);
		return "Issue deleted successfully" +id;

	}
	
	public Issue updateIssue(Issue issue) {
		Issue existingIssue = issueRepo.findById(issue.getId()).orElse(null);
		existingIssue.setIssueName(issue.getIssueName());
		existingIssue.setDescription(issue.getDescription());
		existingIssue.setIssueType(issue.getIssueType());
		existingIssue.setSubject(issue.getSubject());
		return issueRepo.save(existingIssue);
		
	}
}
