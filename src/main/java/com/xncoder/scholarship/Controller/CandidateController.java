package com.xncoder.scholarship.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xncoder.scholarship.Model.Candidate;
import com.xncoder.scholarship.Service.CandidateService;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
	@Autowired
	private CandidateService cs;
	
	@PostMapping("/login")
	public ResponseEntity<?> loginCandidate(@RequestBody Candidate candidate) {
		Candidate user = cs.getCandidateByEmail(candidate.getEmail());
		if(user.getEmail().equals(candidate.getEmail()) && user.getPassword().equals(candidate.getPassword())) {
			return ResponseEntity.ok().body(user);				
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credential does not matched.");
		}
	}	
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody Candidate candidate) {
		Candidate user1 = cs.getCandidateByEmail(candidate.getEmail());
		Candidate user2 = cs.getCandidateByUsername(candidate.getUsername());
		if(user1 == null) {
			if(user2 == null) {
				cs.addCandidate(candidate);
				return ResponseEntity.ok().body("Registered successfully");
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username already registered");
			}
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email already registered");
		}
	}
}
