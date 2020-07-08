package com.harsimran.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harsimran.auth.model.Issue;
import com.harsimran.auth.model.IssueType;
import com.harsimran.auth.service.IssueServiceImpl;
import com.harsimran.auth.web.IssueController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = IssueController.class)
public class IssueControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IssueServiceImpl issueService;

	@Test
	public void testCreateIssue() throws Exception {

		Issue issue = new Issue();
		issue.setId(1l);
		issue.setIssueName("Admin related issue");
		issue.setDescription("Can You please provide me the new chair as my chair is broken and unbalanced");
		issue.setSubject("raising issue regarding change of chair");
		issue.setIssueType(IssueType.ADMIN_ISSUE);

		String inputInJson = this.mapToJson(issue);
		String URI = "/addIssues";

		Mockito.when(issueService.saveIssue(Mockito.any(Issue.class))).thenReturn(issue);
		RequestBuilder req = MockMvcRequestBuilders.post(URI).contentType(inputInJson);

		MvcResult result = mockMvc.perform(req).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	@Test
	public void getAllIssues() throws Exception {
		Issue issue = new Issue();
		issue.setId(1l);
		issue.setIssueName("Admin related issue");
		issue.setDescription("Can You please provide me the new chair as my chair is broken and unbalanced");
		issue.setSubject("raising issue regarding change of chair");
		issue.setIssueType(IssueType.ADMIN_ISSUE);

		List<Issue> issueList = new ArrayList<>();
		issueList.add(issue);

		Mockito.when(issueService.getAllIssues()).thenReturn(issueList);

		String URI = "/viewIssues";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(issueList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);

	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
