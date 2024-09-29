package com.xncoder.scholarship.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xncoder.scholarship.Model.Candidate;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Long> {
	public Candidate findByEmail(String email);
	public Candidate findByUsername(String username);
}
