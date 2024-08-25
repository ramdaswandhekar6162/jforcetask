package com.jforce.pollsystem.services;

import java.util.List;

import com.jforce.pollsystem.entity.Poll;

public interface PollService {
	
	public Poll savePoll(Poll poll);
	
	public List<Poll> findAllPollsd();
	
	public Poll findByPoll(long pollid);
	
	public Poll updatePoll(Poll updatedPoll,long pollId);
	
	
	
}
