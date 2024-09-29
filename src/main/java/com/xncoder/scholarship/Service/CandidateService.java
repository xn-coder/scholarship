package com.xncoder.scholarship.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xncoder.scholarship.ExceptiomClass;
import com.xncoder.scholarship.Model.Candidate;
import com.xncoder.scholarship.Repository.CandidateRepo;

@Service
public class CandidateService {
	@Autowired
	private CandidateRepo cr;
	
	public Candidate getCandidateById(Long id) {
		return cr.findById(id).orElseThrow(() -> new ExceptiomClass("Candidate not found"));
	}
	
	public Candidate getCandidateByEmail(String email) {
		return cr.findByEmail(email);
	}
	
	public Candidate getCandidateByUsername(String username) {
		return cr.findByUsername(username);
	}
	
	public void addCandidate(Candidate candidate) {
		cr.save(candidate);
	}

}
