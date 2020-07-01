package com.harsimran.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harsimran.auth.model.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long>{
	

}
