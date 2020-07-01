package com.harsimran.auth.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harsimran.auth.model.Issue;
import com.harsimran.auth.service.IssueServiceImpl;

@Controller
public class IssueController {
	
	@Autowired
	private IssueServiceImpl issueServiceImpl;
	
	@PostMapping("/addIssue")
	public String reg(Map<String, Object> model) {
		model.put("issueForm", new Issue());
		return "addIssues";
	}
	
	@PostMapping("/addIssues")
	public String createIssue(@ModelAttribute("issueForm") Issue issue) {
		issueServiceImpl.saveIssue(issue);
		return "redirect:/viewIssues";	
	}
	
	@GetMapping("/list")
	public String listOfIssues(Model model) {
		List<Issue> issueList = issueServiceImpl.getAllIssues();
		model.addAttribute("issueList", issueList);
		return "viewIssues";
	}
	
	@PostMapping("/delete")
	public String deleteIssue(@RequestParam("id") int id) {
		issueServiceImpl.deleteIssue((id));
		return "redirect:/viewIssues";		
	}
	
	@GetMapping("/edit")
	public String editIssue(@RequestParam("id") String id, Map<String, Object> model, Issue issue1) {
		Issue issue = issueServiceImpl.updateIssue(issue1);
		model.put("issueForm", issue);
		return "addIssues";
	}
}