package com.jforce.pollsystem.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jforce.pollsystem.entity.Poll;
import com.jforce.pollsystem.exception.ResourceNotFoundException;
import com.jforce.pollsystem.repository.PollRepository;
import com.jforce.pollsystem.services.PollService;



@Service
public class PollImplementaion implements PollService {

	
	@Autowired
	PollRepository pollRepository;
	
	
	@Override
	public Poll savePoll(Poll poll) {
		// TODO Auto-generated method stub
		
		Poll pollSaved = pollRepository.save(poll);
		
		return pollSaved;
	}

	@Override
	public List<Poll> findAllPollsd() {
		// TODO Auto-generated method stub
		
		List<Poll> findAllPolls = pollRepository.findAll();
		
		
		return findAllPolls;
	}

	@Override
	public Poll findByPoll(long pollid) {
		// TODO Auto-generated method stub
		
		Poll pollFounded = pollRepository.findById(pollid).orElseThrow(() -> new ResourceNotFoundException(pollid, "Poll not Founed"));
		
		return pollFounded;
	}

	@Override
	public Poll updatePoll(Poll updatedPoll, long pollId) {
		// TODO Auto-generated method stub
		
		Poll pollFounded = pollRepository.findById(pollId).orElseThrow(() -> new ResourceNotFoundException(pollId, "Poll Not Founded"));
		
		pollFounded.setDescription(updatedPoll.getDescription());
		
		pollFounded.setOption(updatedPoll.getOption());
		
		pollFounded.setTitle(updatedPoll.getTitle());
		
		Poll updatedPollDone = pollRepository.save(pollFounded);
		
		
		return updatedPollDone;
	}

}
