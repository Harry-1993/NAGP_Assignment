package com.harsimran.auth.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.harsimran.auth.model.Issue;
import com.harsimran.auth.service.UserService;

public class IssueValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Issue.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Issue issue = (Issue) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "issuename", "NotEmpty");
		if (issue.getIssueName().length() < 6 || issue.getIssueName().length() > 32) {
			errors.rejectValue("issuename", "Size.issueForm.issuename");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "NotEmpty");
		if (issue.getSubject().length() < 8 || issue.getSubject().length() > 32) {
			errors.rejectValue("subject", "Size.issueForm.subject");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
		if (issue.getDescription().length() < 8 || issue.getDescription().length() > 200) {
			errors.rejectValue("description", "Size.issueForm.description");
		}

	}

}
