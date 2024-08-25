package com.jforce.pollsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jforce.pollsystem.entity.Poll;
import com.jforce.pollsystem.services.PollService;

@RestController
@RequestMapping("/api")
public class PollController {
	
	@Autowired
	PollService pollService;
	
	@PostMapping("/poll/create")
	public ResponseEntity<Poll> createNewPoll(@RequestBody Poll poll) {
		
		Poll savedPoll = pollService.savePoll(poll);
		
		return ResponseEntity.ok().body(savedPoll);
	}
	
	@GetMapping("/poll/find/{pollid}")
	public ResponseEntity<Poll> findPollById(@PathVariable(value = "pollid") long pollid) {
		
		Poll foundedpoll = pollService.findByPoll(pollid);
		
		return ResponseEntity.ok().body(foundedpoll);
	}
	
	@PutMapping("/poll/update/{pollid}")
	public ResponseEntity<Poll> updatePollById(@PathVariable(value = "pollid") long pollid, @RequestBody Poll updatePoll) {
		
		Poll updatePoll2 = pollService.updatePoll(updatePoll, pollid);
		
		return ResponseEntity.ok().body(updatePoll2);
	}
	
	@GetMapping("/poll/findall")
	public ResponseEntity<List<Poll>> findAllPoll() {
		List<Poll> findAllPollsd = pollService.findAllPollsd();
		
		return ResponseEntity.ok().body(findAllPollsd);
	}
	
	

}
